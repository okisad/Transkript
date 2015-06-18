package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.UserDAO;
import com.interfaces.UserService;
import com.model.UserServiceImp;


@WebServlet(urlPatterns={"/registerservlet"})
public class RegisterController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		
		
		UserService userService = new UserServiceImp();
				
		if(userService.registerProcess(req)){
			
			resp.sendRedirect(req.getContextPath()+"/index.jsp?isSuccessful="+URLEncoder.encode(userService.getInfo(), "UTF-8").replace("+", "%20"));
			
		}else{
			
			resp.sendRedirect(req.getContextPath()+"/index.jsp?errorreg="+URLEncoder.encode(userService.getInfo(), "UTF-8").replace("+", "%20"));
			
		}
		
		
	}

	
	
}
