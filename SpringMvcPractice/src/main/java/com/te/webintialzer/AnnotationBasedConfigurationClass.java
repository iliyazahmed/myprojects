package com.te.webintialzer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.te")
@EnableWebMvc  // this is equal to <mvc:annotation-driven />
public class AnnotationBasedConfigurationClass {
    
	@Bean
	public LocalEntityManagerFactoryBean getFactory() {
		LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("Iliyazz App's");
		return factoryBean;
	}
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver myViewResolver = new InternalResourceViewResolver();
		myViewResolver.setPrefix("/WEB-INF/views/");
		myViewResolver.setSuffix(".jsp");
		return myViewResolver;
	}
	
}
