package com.example.shared.web.doc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DocConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        SecurityScheme securityScheme = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer");

        Components components = new Components()
                .addSecuritySchemes("Bearer Token", securityScheme);

        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList("Bearer Token"))
                .components(components);
    }
}
