package org.springboot.monitoring.api.config;

import org.springboot.monitoring.api.controllers.TodoController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(TodoController.class.getPackageName()))
                .build()
                .apiInfo(metadata());
    }

    public ApiInfo metadata()  {
        return new ApiInfoBuilder()
                .title("SpringBoot Monitoring Grafana API")
                .description("Demo project for Spring Boot with Grafana :D")
                .version("0.1.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .contact(new Contact("Alan Rodriguez", "https://github.com/alanrzz", "alanrodriguezalexandro@gmail.com"))
                .build();
    }
}
