package com.ecommerce.web.utilities;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class UserIdGenerator implements  IdentifierGenerator{

	@Override
	public Serializable generate(SharedSessionContractImplementor session	, Object object) throws HibernateException {
		
		return "USER"+new Random().nextLong();
	}

}
