package com.poly.son;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.poly.son.entity.Account;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class AuthInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		Account user = (Account) request.getSession().getAttribute("user");
		
		String error = "";
		if(user == null) {
			error = "Please Login!";
		} else if(!(user.getRoleId().getId() == 2) && uri.startsWith("/manager/")) {
			error = "Access denied!";
		}
		
		if(error.length() > 0) {
			request.getSession().setAttribute("security-uri", uri);
			response.sendRedirect("/log-in");
			return false;
		}
		return true;
	}
}
