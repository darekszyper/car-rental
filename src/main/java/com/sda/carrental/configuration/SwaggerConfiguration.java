package com.sda.carrental.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI vamosServerOpenAPI() {
        //final String securitySchemeName = "bearerAuth";
        return new OpenAPI()
                .info(new Info()
                        .title("CarRental Server API")
                        .version("v0.0.1-DEV")
                        .description("API służące do zarządzania wypożyczalnią samochodów."))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentation")
                        .url("https://docs.google.com/document/d/1a5gO2DCrmwOCJKrU5APUQKIUNt1LRHTxNfn0dCI8Ctw/edit"));
                //.addSecurityItem(new SecurityRequirement()
                //        .addList(securitySchemeName))
                //.components(new Components()
//                        .addSecuritySchemes(securitySchemeName, new SecurityScheme()
//                                .name(securitySchemeName)
//                                .type(SecurityScheme.Type.HTTP)
//                                .scheme("bearer")
//                                .bearerFormat("JWT")));
    }
}