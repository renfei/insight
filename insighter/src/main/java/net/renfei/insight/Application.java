package net.renfei.insight;

import org.apache.commons.cli.*;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Insight 程序入口
 *
 * @author renfei
 */
@EnableScheduling
@EnableFeignClients
@SpringBootApplication
@EnableConfigurationProperties
public class Application {
    public static void main(String[] args) {
        final CommandLineParser parser = new BasicParser();
        Options options = new Options();
        options.addOption("h", "help", false, "显示帮助信息");
        options.addOption("i", "id", false, "Agent的UUID编号");
        options.addOption("u", "url", false, "上报主机地址：https://demo.com");
        options.addOption("p", "print", false, "是否在Agent上打印扫描结果，默认为否");
        options.addOption("c", "cron", false, "定时任务cron表达式，默认为2秒一次");
        CommandLine commandLine = null;
        try {
            commandLine = parser.parse(options, args);
        } catch (final ParseException e) {
            System.out.println("parser command line error");
            new HelpFormatter().printHelp("java -jar insight.jar [args]", options);
            System.exit(0);
        }
        if (commandLine.hasOption('h')) {
            new HelpFormatter().printHelp("java -jar insight.jar [args]", options);
            System.exit(0);
        }
        if (commandLine.hasOption('i')) {
        } else {
            System.out.println("Agent的UUID编号为空");
            new HelpFormatter().printHelp("java -jar insight.jar [args]", options);
            System.exit(0);
        }
        if (commandLine.hasOption("u")) {
        } else {
            System.out.println("上报主机地址为空");
            new HelpFormatter().printHelp("java -jar insight.jar [args]", options);
            System.exit(0);
        }
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }
}
