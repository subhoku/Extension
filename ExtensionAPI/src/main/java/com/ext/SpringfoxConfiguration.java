package com.ext;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringfoxConfiguration {

	@Bean
	Docket generatedDocket() {
		return docket().groupName("Extnesion Project V 1.0");
	}

	public Docket docket() {
		Parameter authHeader = new ParameterBuilder()
									.parameterType("header")
									.name("Authorization")
									.defaultValue("")
									.modelRef(new ModelRef("string"))
									.build();
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ext"))
				.build()
				.apiInfo(apiInfo())
				.globalOperationParameters(Collections.singletonList(authHeader));
	}

	public ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Extnesion Project REST api")
				.description("Generated documentation for Extnesion Project ")
				.termsOfServiceUrl("")
				.version("1.0.0")
				.contact(new Contact("", "", "")).build();
	}

}