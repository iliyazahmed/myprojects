package com.example.crudoperations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MyFirstTaskApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(MyFirstTaskApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(MyFirstTaskApplication.class, args);
		logger.info("It's Working for info message");
		logger.warn("It's Working for warn message");
		logger.debug("It's Working for debug message");
		logger.trace("It's Working for trace message");
		
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		//returning Docket for configuring Swagger.
		return new Docket(DocumentationType.SWAGGER_2).
				select().
				paths(PathSelectors.ant("/api/*")).
				apis(RequestHandlerSelectors.basePackage("com.example.crudoperations")).
				build();
	}
    
	@Bean
	public ApiInfo apiInfo() {
		return new ApiInfoBuilder().
				description("Employee Management Api").
				title("Employee Details").
				license("Think N Solutions").
				build();
	}
}
