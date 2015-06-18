package com.interfaces;

import java.util.List;

import com.abstracts.SchoolInfo;
import com.entity.UserDAO;

public interface UserDatabaseService {

	public boolean isExistUser(UserDAO user);
	
	public boolean isRegisterSuccess(UserDAO user);
	
	public boolean isLoginSuccess(UserDAO user);
	
	public boolean inputProcess(UserDAO user);
	
	public UserDAO getPersonFromEmail(String email);
	
	public String getInfo();
	
	public UserDAO getUser();
	
}
