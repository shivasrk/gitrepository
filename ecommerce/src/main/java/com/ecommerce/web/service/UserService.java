package com.ecommerce.web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.web.model.Users;
import com.ecommerce.web.repositories.UsersRepository;

@Service
public class UserService {
	
	
	private UsersRepository usersRepository;
	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void saveUser(Users user)
	{
		usersRepository.save(user);
	}

}
