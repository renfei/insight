package net.renfei.insight.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author renfei
 */
@Configuration
public class Config {
    private final ApplicationArguments applicationArguments;
    public String uuid;
    public String url;
    public String cron;
    public boolean print;

    public Config(ApplicationArguments applicationArguments) {
        this.applicationArguments = applicationArguments;
        uuid = getArg("-i");
        url = getArg("-u");
        cron = getArg("-c");
        print = getArg("-p") != null;
    }

    private String getArg(String key) {
        List<String> arr = applicationArguments.getNonOptionArgs();
        int j = -1;
        for (int i = 0; i < arr.size(); i++) {
            if (key.equals(arr.get(i))) {
                j = i + 1;
                break;
            }
        }
        if (j > 0 && j < arr.size()) {
            return arr.get(j);
        }
        return null;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public boolean isPrint() {
        return print;
    }

    public void setPrint(boolean print) {
        this.print = print;
    }
}
