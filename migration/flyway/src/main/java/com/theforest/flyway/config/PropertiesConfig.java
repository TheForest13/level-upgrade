package com.theforest.flyway.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class PropertiesConfig {
    @Value("${flyway.url}")
    private String urlDb;

    @Value("${flyway.user}")
    private String userDb;

    @Value("${flyway.password}")
    private String passwordDb;
}
