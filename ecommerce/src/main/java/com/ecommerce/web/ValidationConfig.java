package com.ecommerce.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
@Configuration
@ComponentScan("com.ecommerce.web.model")
public class ValidationConfig {
	
	@Bean
	public LocalValidatorFactoryBean localValidatorBeanFactory() {
		return  new LocalValidatorFactoryBean();
	}

}
