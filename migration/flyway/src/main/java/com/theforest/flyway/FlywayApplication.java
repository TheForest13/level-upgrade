package com.theforest.flyway;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FlywayApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(FlywayApplication.class, args);
        Flyway flyway = run.getBean("flyway", Flyway.class);
        flyway.migrate();
    }

}
