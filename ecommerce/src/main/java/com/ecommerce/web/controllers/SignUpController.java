package com.ecommerce.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecommerce.web.model.Users;
import com.ecommerce.web.service.UserService;



@Controller
public class SignUpController {

	@Autowired
	private UserService userService;
	
	static {
		System.out.println("controller");
	}
//Logger log = Logger.getLogger(SignUpController.class);
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String signUp()
		{
		//System.out.println(user.getEmail()+"  "+user.getPassword());
		return   "welcome";
				
	}
	
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String formUp()
	{
	//System.out.println(user.getEmail()+"  "+user.getPassword());
	return   "form";			
}
	
	@RequestMapping(value="user",method=RequestMethod.POST)
	public void register( @Valid Users user,BindingResult result)
	{
		
	System.out.println(user.getEmail());
	userService.saveUser(user);
	System.out.println("user inserted");
	}
}
