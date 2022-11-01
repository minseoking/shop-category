package com.ms.discovery.application.configs;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    
    @Bean
    public GroupedOpenApi jwtApi() {
        String[] paths = {"/api/**"};
        return GroupedOpenApi.builder()
                .group("카테고리 API")
                .pathsToMatch(paths)
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("카테고리 API 문서")
                        .description("헥사고날 아키텍처 기반 카테고리 API 문서")
                        .version("v0.0.1"));
    }
}
