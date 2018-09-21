package com.ecommerce.web.utilities;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.ecommerce.web.model.Users;

/*
 * class for validating the username by implementing the constraint validation
 * @author D SHIVARAMAKRISHNA
 * 
 */

public class UsernameValidator implements ConstraintValidator<Username, Users> {


	@Override
	public void initialize(Username constraintAnnotation) {
	}
	
	
	
	// overrided method
	@Override
	public boolean isValid(Users value, ConstraintValidatorContext context) {
		String user_name = value.getName();
		if (!user_name.trim().isEmpty() && user_name != null)
			for (int i = 0; i < user_name.length(); i++) {
				char ch = user_name.charAt(i);
				if (!Character.isLetterOrDigit(ch))
					return false;
			}
		return true;
	}
}
