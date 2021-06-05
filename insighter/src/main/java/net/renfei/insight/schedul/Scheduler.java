package net.renfei.insight.schedul;

import net.renfei.insight.config.Config;
import net.renfei.insight.scan.ReportScan;
import net.renfei.sdk.utils.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;
import org.springframework.scheduling.config.CronTask;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

/**
 * 定时任务执行器
 *
 * @author renfei
 */
@Component
public class Scheduler {
    private final Config config;
    private final ReportScan reportScan;
    private final ApplicationContext applicationContext;
    private final ConcurrentHashMap<String, ScheduledFuture<?>> scheduledFutureMap = new ConcurrentHashMap<>();

    public Scheduler(Config config,
                     ReportScan reportScan,
                     ApplicationContext applicationContext) {
        this.config = config;
        this.reportScan = reportScan;
        this.applicationContext = applicationContext;
    }

    @Scheduled(cron = "0/2 * * * * ? ")
    public void reportScan() {
        setScheduled();
        reportScan.report();
    }

    private void setScheduled() {
        if (!BeanUtils.isEmpty(config.getCron())) {
            ScheduledAnnotationBeanPostProcessor postProcessor = applicationContext.getBean(ScheduledAnnotationBeanPostProcessor.class);
            Field registrar = null;
            try {
                registrar = postProcessor.getClass().getDeclaredField("registrar");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            assert registrar != null;
            registrar.setAccessible(true);
            ScheduledTaskRegistrar taskRegistrar = null;
            try {
                taskRegistrar = (ScheduledTaskRegistrar) registrar.get(postProcessor);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            assert taskRegistrar != null;
            TaskScheduler scheduler = taskRegistrar.getScheduler();
            Set<ScheduledTask> scheduledTaskSet = postProcessor.getScheduledTasks();

            for (ScheduledTask scheduledTask : scheduledTaskSet) {
                String methodFullName = "";
                if (scheduledTask.getTask().getRunnable().toString().equals(methodFullName)) {
                    scheduledTask.cancel();
                    CronTask cronTask = new CronTask(scheduledTask.getTask().getRunnable(), config.getCron());
                    if (scheduledFutureMap.containsKey(methodFullName)) {
                        ScheduledFuture<?> scheduledFuture = scheduledFutureMap.get(methodFullName);
                        scheduledFuture.cancel(true);
                    }
                    assert scheduler != null;
                    ScheduledFuture<?> scheduledFuture = scheduler.schedule(cronTask.getRunnable(), cronTask.getTrigger());
                    assert scheduledFuture != null;
                    scheduledFutureMap.put(methodFullName, scheduledFuture);
                }
            }
        }
    }
}
