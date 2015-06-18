package com.model;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.routines.EmailValidator;

import com.entity.UserDAO;
import com.interfaces.UserDatabaseService;
import com.interfaces.UserService;

public class UserServiceImp implements UserService {

	private UserDatabaseService databaseService;

	private String info;

	private UserDAO user;

	@Override
	public boolean loginProcess(HttpServletRequest req) {

		databaseService = new UserDatabaseServiceImp();

		UserDAO arrangedUser = arrangementLoginOfUser(req);
		
		if (this.isValidEmail(arrangedUser)) {

			if (databaseService.isLoginSuccess(arrangedUser)) {

				this.setUser(databaseService.getUser());

				return true;

			} else {

				this.setInfo(this.getDatabaseService().getInfo());

				return false;

			}

		} else {

			return false;

		}

	}

	@Override
	public boolean registerProcess(HttpServletRequest req) {

		UserDAO arrangedUser = arrangementRegisterOfUser(req);

		this.databaseService = new UserDatabaseServiceImp();

		if (this.isValidEmail(arrangedUser)) {

			if (this.isValidPassword(arrangedUser)) {

				if (databaseService.isRegisterSuccess(arrangedUser)) {

					this.setInfo(databaseService.getInfo());

					return true;

				} else {

					this.setInfo(databaseService.getInfo());

					return false;

				}

			} else {

				return false;

			}

		} else {

			return false;

		}

	}

	@Override
	public boolean isValidEmail(UserDAO user) {
		if (EmailValidator.getInstance().isValid(user.getEmail())) {
			return true;
		} else {
			this.setInfo("Lütfen geçerli bir email adresi girin");
			return false;
		}
	}

	@Override
	public boolean isValidPassword(UserDAO user) {

		if (user.getPassword1().length() >= 6
				&& user.getPassword1().length() <= 20) {

			if (this.isMatchingPasswords(user)) {

				return true;

			} else {

				return false;

			}

		} else {

			this.setInfo("Şifre 6 karakterden fazla ve 20 karakterden az olmalıdır");

			return false;

		}

	}

	@Override
	public boolean isMatchingPasswords(UserDAO user) {

		if (user.getPassword1().equals(user.getPassword2())) {

			return true;

		} else {

			this.setInfo("Şifreler uyuşmamaktadır");

			return false;

		}

	}

	private UserDAO arrangementRegisterOfUser(HttpServletRequest req) {

		String email = req.getParameter("sign-up-email");

		String pass1 = req.getParameter("sign-up-password1");

		String pass2 = req.getParameter("sign-up-password2");

		UserDAO user = new UserDAO();

		user.setEmail(email);

		user.setPassword1(pass1);

		user.setPassword2(pass2);

		return user;

	}

	private UserDAO arrangementLoginOfUser(HttpServletRequest req) {

		String email = req.getParameter("email");

		String pass = req.getParameter("password");
		
		UserDAO userDAO =new UserDAO();
		
		userDAO.setEmail(email);
		
		userDAO.setPassword1(pass);
		
		return userDAO;

	}

	public UserDatabaseService getDatabaseService() {
		return databaseService;
	}

	public void setDatabaseService(UserDatabaseService databaseService) {
		this.databaseService = databaseService;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public UserDAO getUser() {
		return user;
	}

	public void setUser(UserDAO user) {
		this.user = user;
	}

}
