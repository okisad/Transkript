package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.UserDAO;
import com.model.FormService;


@WebServlet(urlPatterns = { "/mainPageServlet" })
public class TranskriptTableController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		if (req.getParameter("kaydet") != null) {

			PrintWriter pw = resp.getWriter();

			FormService formService = new FormService(req);

			Enumeration<String> map = req.getParameterNames();

			UserDAO person = (UserDAO) req.getSession(false).getAttribute(
					"person");

			System.out.println(person);

			if (formService.handleAllInput(map, person)) {

				resp.sendRedirect(req.getContextPath()
						+ "/mainPage.jsp?info=Kayit Basarili");

			} else {

				resp.sendRedirect(req.getContextPath()
						+ "/mainPage.jsp?info=Kayit Basarisiz");

			}

		}

		if (req.getParameter("logout") != null) {

			req.getSession(false).invalidate();

			Cookie[] cookies = req.getCookies();

			for (Cookie cookie : cookies) {

				cookie.setMaxAge(-1);

			}

			resp.sendRedirect(req.getContextPath() + "/index.jsp");

		}

	}

}
