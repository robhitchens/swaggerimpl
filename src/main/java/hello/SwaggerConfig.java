package hello;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //NOTE Swagger UI is accessible at localhost:8080/swagger-ui.html
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
        .select()
        //can also restrict documentation using RequestHandlerSelectors.basePackage("com.wsfsbank.package").
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build()
        .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        return new ApiInfo(
            "My REST Api",
            "Some custom description of API",
            "API TOS",
            "Terms of service",
            new Contact("Robert Hitchens", "myfoot.ur.ass", "rhitchens@wsfsbank.com"),
            "License of API",
            "API License URL",
            Collections.emptyList());//Vender extensions.
    }
}
