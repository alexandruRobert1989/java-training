package org.training.javatraining.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Java Training API",
                version = "1.0",
                description = "API documentation for the Java Training application"
        )
)
public class OpenApiConfig {
    // Additional custom configurations if needed
}
