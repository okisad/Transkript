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
		urlPatterns={"/index.jsp"}
	)
public class HomeSessionFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest request = (HttpServletRequest) arg0;
		
		HttpServletResponse response = (HttpServletResponse) arg1;
 		
		
		if(request.getSession(false) == null){
			
			System.out.println("session yok");
			
			arg2.doFilter(arg0, arg1);
						
		}else{
			
			UserDAO p = (UserDAO) request.getSession(false).getAttribute("person");
			
			if(p==null){
				
				arg2.doFilter(arg0, arg1);
				
			}else{
			
				System.out.println("session var");
				
				response.sendRedirect(request.getContextPath()+"/index.jsp");
				
			}
					
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
	
}
