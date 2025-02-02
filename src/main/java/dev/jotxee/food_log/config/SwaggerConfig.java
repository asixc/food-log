package dev.jotxee.food_log.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    public static final String GITHUB_URL_REPOSITORY = "https://github.com/asixc/food-log";
    @Value("${swagger.base-url}")
    private String baseUrl;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Meal log API")
                        .description("Swagger documentation for Meal Log API")
                        .version("v1.0"))
                .servers(List.of(new Server().url(baseUrl)))  // Usar la URL dinámica
                .externalDocs(new ExternalDocumentation()
                        .description("Repository")
                        .url(GITHUB_URL_REPOSITORY));  // Configurar la URL de Swagger UI
    }
}
