package com.interfaces;

import javax.servlet.http.HttpServletRequest;

import com.entity.UserDAO;

public interface UserService {

	public boolean loginProcess(HttpServletRequest req);
	
	public boolean registerProcess(HttpServletRequest req);
	
	public boolean isValidEmail(UserDAO user);
	
	public boolean isValidPassword(UserDAO user);
	
	public boolean isMatchingPasswords(UserDAO user);
	
	public String getInfo();
	
	public UserDAO getUser();
		
}
