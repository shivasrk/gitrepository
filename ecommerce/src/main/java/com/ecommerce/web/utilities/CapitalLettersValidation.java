package com.ecommerce.web.utilities;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


import com.ecommerce.web.model.Users;

public class CapitalLettersValidation implements ConstraintValidator<Capital, Users> {

	
	@Override
	public void initialize(Capital constraintAnnotation) {
	}
	
	
	
	@Override
	public boolean isValid(Users value, ConstraintValidatorContext context) {
		
		String name=value.getName();
		String noWhiteSpace = capitalLetters(name);
	boolean result=isCapital(noWhiteSpace);
	
		return result;
	}

	public static String capitalLetters(String name) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < name.length(); i++) {
			char ch = name.charAt(i);
			if (!Character.isWhitespace(ch))
				sb.append(ch);
		}
		return sb.toString();
	}

public static boolean isCapital(String name) {
	
	for(int i=0;i<name.length();i++) {
		char ch=name.charAt(i);
		if(!Character.isUpperCase(ch))
			return false;
			}		
return true;
}
}