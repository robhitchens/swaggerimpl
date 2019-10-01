package hello.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //NOTE Swagger UI is accessible at localhost:8080/swagger-ui.html
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //can also restrict documentation using RequestHandlerSelectors.basePackage("com.wsfsbank.package").
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, List.of(
                        new ResponseMessageBuilder()
                                .code(500)
                                .message("500 message")
                                //.responseModel(new ModelRef("Error"))//NOTE: response model doesn't seem to work here.
                                .build(),

                        new ResponseMessageBuilder()
                                .code(403)
                                .message("Forbidden")
                                .build()
                ))
                ;
    }

    private ApiInfo apiInfo() {
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
