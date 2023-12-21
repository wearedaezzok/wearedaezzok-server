package com.wearedaezzok.daezzokserver.global.config

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {
    @Bean
    fun openAPI(): OpenAPI {
        val info =
            Info()
                .title("Pophory API V1 Spec")
                .description("Pophory API V1 Document")
                .version("1.0.0")
        return OpenAPI()
            .components(Components())
            .info(info)
    }
}
