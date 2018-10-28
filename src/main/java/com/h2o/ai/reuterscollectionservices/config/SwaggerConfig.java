package com.h2o.ai.reuterscollectionservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket swaggerSettings() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.h2o.ai.reuterscollectionservices"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        Contact test = new Contact("Xueyi Wang",null,"wangxueyi0524@gmail.com");
        return new ApiInfo(
                "Reutes Service",
                "API's to perform all the business logic to be performed on Reuters database",
                "001",
                "Terms of service",
                test,
                "License of API",
                "API license URL",
                Collections.emptyList()
                );
    }
}
