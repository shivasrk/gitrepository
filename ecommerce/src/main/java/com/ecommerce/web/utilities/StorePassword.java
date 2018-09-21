package com.ecommerce.web.utilities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
 * A utility class for storing the password
 * @author D SHIVARAMAKRISHNA
 */
public class StorePassword {

	// adding salt string to make password hash
	private final static String salt = "myLoginPassword";

	// Method to convert the password into hashPassword for security reasons
	public static String storePassword(String password) {
		// making thr password as hashpassword by concating the salt parameter
		String hashPassword = salt + password;
		// creating the innstance of String builder
		StringBuilder hash = new StringBuilder();
		try {
			//MessageDigest Class for getting the instance of specified algorthm 
			//in this case we are using SHA-1 algorithm
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte hashBytes[] = sha.digest(hashPassword.getBytes());
			char[] digits = { '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
			for (int idx = 0; idx < hashBytes.length; idx++) {
				byte b = hashBytes[idx];
				hash.append(digits[(b & 0xf0) >> 4]);
				hash.append(digits[b & 0x0f]);

			}
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}

		return hash.toString();
	}
}
