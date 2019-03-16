package guru.springfamework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * Created by jt on 12/20/17.
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {//extends WebMvcConfigurationSupport {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .apiInfo(metaData()); // added this
    }

    // need addResourceHandlers(ResourceHandlerRegistory registroy){} if using normal mvc

    private ApiInfo metaData()
    {
        Contact contact = new Contact("Andre Lussier","https://springframework.guru/about/", "fakeemail.com");

        return new ApiInfo(
                "Spring Framework",
                "Spring Framework 5: training",
                "1.0",
                "Terms of service: ",
                contact,
                "Apache License Version 2.0",
                "Https://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>());
    }


}
