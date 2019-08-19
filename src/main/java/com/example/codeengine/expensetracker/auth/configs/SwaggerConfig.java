package com.example.codeengine.expensetracker.auth.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collection;
import java.util.Collections;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket productApi(){
         return new Docket(DocumentationType.SWAGGER_2)
                 .select()
                 .apis(RequestHandlerSelectors.basePackage("com.example.codeengine.expensetracker.auth")) //.apis(RequestHandlerSelectors.any())
                 .paths(PathSelectors.any()) //paths(PathSelectors.any())
            .build()
                 .apiInfo(apiInfo());
    }
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "ADL Expense Tracker App",
                "ADL Expense Tracker App service REST API Documentation.",
                "API TOS",
                "http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open",
                new Contact("Software Team", "www.dialog.lk", "SoftwareTeam@dialog.lk"),
                "Apache License Version 2.0", "https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE");
    }
}
