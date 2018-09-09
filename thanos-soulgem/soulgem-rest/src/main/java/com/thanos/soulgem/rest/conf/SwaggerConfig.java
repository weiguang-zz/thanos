package com.thanos.soulgem.rest.conf;

import com.fasterxml.classmate.TypeResolver;
import com.google.common.collect.ImmutableList;
import java.lang.reflect.Type;
import org.bson.types.ObjectId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;
import springfox.documentation.builders.AlternateTypeBuilder;
import springfox.documentation.builders.AlternateTypePropertyBuilder;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRule;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Loops .
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    TypeResolver typeResolver = new TypeResolver();

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .alternateTypeRules(new AlternateTypeRule(typeResolver.resolve(ObjectId.class),typeResolver.resolve(String.class)),
                new AlternateTypeRule(typeResolver.resolve(Pageable.class), typeResolver.resolve(pageableMixin())))
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.thanos.soulgem.rest.controller"))
            .paths(PathSelectors.any())
            .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Thanos API文档")
            .description("Thanos API文档")
            .termsOfServiceUrl("https://www.thanos.com/")
            .version("1.0")
            .build();
    }

    private Type pageableMixin() {
        return new AlternateTypeBuilder()
            .fullyQualifiedClassName(
                String.format("%s.generated.%s",
                    Pageable.class.getPackage().getName(),
                    Pageable.class.getSimpleName()))
            .withProperties(ImmutableList.of(
                property(Integer.class, "page"),
                property(Integer.class, "size"),
                property(String.class, "sort")
            ))
            .build();
    }

    private AlternateTypePropertyBuilder property(Class<?> type, String name) {
        return new AlternateTypePropertyBuilder()
            .withName(name)
            .withType(type)
            .withCanRead(true)
            .withCanWrite(true);
    }

}
