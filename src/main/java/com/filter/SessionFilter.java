package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.UserDAO;


@WebFilter(
			urlPatterns={"/mainPage.jsp"}
		)
public class SessionFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain arg2) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		
		HttpServletResponse response = (HttpServletResponse) res;
 		
		
		if(request.getSession(false) == null){
			
			System.out.println("session yok");
			
			response.sendRedirect(request.getContextPath()+"/homePage.html");
			
		}else{
			
			UserDAO p = (UserDAO) request.getSession(false).getAttribute("person");
			
			if(p==null){
				
				System.out.println("sessizzon yok");
				
				response.sendRedirect(request.getContextPath()+"/index.jsp");
				
			}else{
			
			System.out.println("session ok");
			
			arg2.doFilter(req, res);
			
			}
		}
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("filter starts");
	}
	
	

}
