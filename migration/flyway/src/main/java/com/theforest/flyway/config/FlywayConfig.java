package com.theforest.flyway.config;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.ClassicConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayConfig {

    @Autowired
    private PropertiesConfig properties;

    @Bean
    public Flyway flyway() {
        ClassicConfiguration configuration = new ClassicConfiguration();
        configuration.setDataSource(
                properties.getUrlDb(),
                properties.getUserDb(),
                properties.getPasswordDb()
                );
        return new Flyway(configuration);
    }

//    @Bean
    public FlywayMigrationStrategy flywayMigrationStrategy() {
        return flyway -> {
//            flyway.validate();
//            flyway.migrate();
        };
    }
}
