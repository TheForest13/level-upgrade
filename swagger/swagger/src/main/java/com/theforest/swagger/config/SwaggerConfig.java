package com.theforest.swagger.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(servers = {@Server(url = "one-local"), @Server(url = "two-local")})
@Configuration
public class SwaggerConfig {
}
