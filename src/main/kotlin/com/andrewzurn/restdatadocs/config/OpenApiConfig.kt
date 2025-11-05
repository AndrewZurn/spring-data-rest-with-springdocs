package com.andrewzurn.restdatadocs.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.media.Schema
import org.springdoc.core.customizers.OpenApiCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {

    @Bean
    fun userRequestBodyCustomizer(): OpenApiCustomizer = OpenApiCustomizer { openApi: OpenAPI ->
        val requestBodyList =
            openApi.components?.schemas?.filter { it.key.contains("requestbody", ignoreCase = true) }?.keys
        requestBodyList?.forEach { key ->
            openApi.components?.schemas?.get(key)?.let { schema: Schema<*> ->
                schema.properties?.remove("id")
                schema.required?.remove("id")
            }
        }
    }
}
