package net.renfei.insight.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author renfei
 */
@Configuration
public class ClientConfig {
    private final Config config;

    public ClientConfig(Config config) {
        this.config = config;
    }

    @Bean
    public RequestInterceptor headerInterceptor() {
        String url = config.getUrl();
        if (url != null) {
            return template -> template.target(url);
        }
        return template -> {
        };
    }
}
