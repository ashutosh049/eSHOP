/**
 * 
 */
package com.wrap.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

/**
 * DESCRIPTION GOES HERE<br>
 * <br>
 * Copyright (c) 2016 kumar.ashutosh@skillnetinc.com
 * 
 * @author ashu
 * @created Oct 30, 2016
 * @version $Revision$
 */
public class WrapAuthenticationFailureHandler implements
AuthenticationFailureHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.web.authentication.AuthenticationFailureHandler
	 * #onAuthenticationFailure(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse,
	 * org.springframework.security.core.AuthenticationException)
	 */
	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException exception)
					throws IOException, ServletException {
		
		String message = "";

		if(exception instanceof UsernameNotFoundException) {
			message = "Invalid Username";
		} else if(exception instanceof BadCredentialsException) {
			message = "Bad credentials";
		}
		final HttpSession session = request.getSession();
		session.setAttribute("errorMessage", message);
		//authentication-failure-url="/authenticate?error=true" 
//		request.getRequestDispatcher(String.format("/error?message=%s", message)).forward(request, response);
		redirectStrategy.sendRedirect(request, response, "/authenticate?error="+message);
	}

}
