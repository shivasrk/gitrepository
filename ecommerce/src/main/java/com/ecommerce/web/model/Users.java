package com.ecommerce.web.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;


import com.ecommerce.web.utilities.Capital;
import com.ecommerce.web.utilities.Username;

@Entity
@Table(name="users")
public class Users implements Serializable {

	/**
	 * serial id version
	 */
	private static final long serialVersionUID = 4069565124876146586L;
	@Capital
	private String name;
	@Id
	@GenericGenerator(name="usergenerator",strategy="com.ecommerce.web.utilities.UserIdGenerator")
	@GeneratedValue(generator="usergenerator")
	private String userId;
	@Username
	private String username;
	@Pattern(regexp="(?=^.{6,255}$)((?=.*\\d)(?=.*[A-Z])(?=.*[a-z])|(?=.*\\d)(?=.*[^A-Za-z0-9])(?=.*[a-z])|(?=.*[^A-Za-z0-9])(?=.*[A-Z])(?=.*[a-z])|(?=.*\\d)(?=.*[A-Z])(?=.*[^A-Za-z0-9]))^.*",message="password is not valid")
	private String password;
	@Email
	private String email;
	
	@Version
	private Long version;
	
	@NotNull
	private String gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public boolean equals(Object o) {		
		if(o==this)
			return true;
		if(!(o instanceof Users))
			return false;
			
		Users user = (Users)o;
		if(this.userId!=null&&user.userId!=null&&user.userId!=""&&this.userId!="")
			return user.userId.equals(this.userId);
		return false;
	}
	@Override
	public int hashCode() {
		int result=17;
		result=31*result+userId.hashCode();
		return result;
	}
	
}
