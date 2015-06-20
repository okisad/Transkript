package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.interfaces.UserService;
import com.model.UserServiceImp;

@WebServlet(urlPatterns = { "/loginservlet" })
public class LoginController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("girdi");
		
		PrintWriter out = resp.getWriter();

		UserService userService = new UserServiceImp();

		if (userService.loginProcess(req)) {

			req.getSession(true);

			req.getSession(false).setAttribute("person",
					userService.getUser());

			Cookie cookie = new Cookie("email", userService.getUser().getEmail());

			cookie.setMaxAge(60 * 60 * 24);

			resp.addCookie(cookie);
			
			resp.sendRedirect(req.getContextPath()+"/mainPage.jsp");

		} else {

			resp.sendRedirect(req.getContextPath()+"/index.jsp?errorlog="+URLEncoder.encode(userService.getInfo(),"UTF-8").replace("+", "%20"));

		}
	}

}
