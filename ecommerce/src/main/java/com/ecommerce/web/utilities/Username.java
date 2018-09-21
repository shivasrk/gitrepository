package com.ecommerce.web.utilities;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@Documented
@Constraint(validatedBy=UsernameValidator.class)
public @interface Username {

	String message() default "Username must contain the alphanumberic number";
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
		
}
