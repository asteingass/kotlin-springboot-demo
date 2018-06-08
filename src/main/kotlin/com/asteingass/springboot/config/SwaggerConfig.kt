package com.asteingass.springboot.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.swagger2.annotations.EnableSwagger2
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.builders.PathSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import java.util.*
import springfox.documentation.service.ApiKey




@Configuration
@EnableSwagger2
class SwaggerConfig {
    @Bean
    fun api(): Docket = Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.asteingass.springboot.controller"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiInfo())
            .securitySchemes(Arrays.asList(apiKey()))

    private fun apiInfo(): ApiInfo {
        return ApiInfo(
                "Kotlin-Springboot-Demo-API",
                "I created this API as a playground to learn about Kotlin, Spring Boot, JWT, Docker and automated Swagger generation",
                "1.0",
                "Terms of service",
                Contact("Andreas Steingaß", "", "andreas.steingass@gmail.com"),
                "License of API", "API license URL", Collections.emptyList())
    }

    private fun apiKey(): ApiKey {
        return ApiKey("authkey", "Authorization", "header")
    }
}