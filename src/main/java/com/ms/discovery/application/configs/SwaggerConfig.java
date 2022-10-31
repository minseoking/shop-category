package com.ms.discovery.application.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "카테고리 API 문서",
                description = "헥사고날 아키텍처 기반 카테고리 API 문서",
                version = "v1"))
@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi OpenApi() {
        String[] paths = {"/api/**"};

        return GroupedOpenApi.builder()
                .group("카테고리 API")
                .pathsToMatch(paths)
                .build();
    }
}
