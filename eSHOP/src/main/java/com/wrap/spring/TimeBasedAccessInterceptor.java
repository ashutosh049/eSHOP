/**
 * 
 */
package com.wrap.spring;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * DESCRIPTION GOES HERE<br>
 * <br>
 * Copyright (c) 2016 kumar.ashutosh@skillnetinc.com
 *
 * @author ashu
 * @created Oct 20, 2016
 * @version $Revision$
 */
public class TimeBasedAccessInterceptor extends HandlerInterceptorAdapter {
	 private int openingTime;
	    private int closingTime;

	    public void setOpeningTime(int openingTime) {
	        this.openingTime = openingTime;
	    }

	    public void setClosingTime(int closingTime) {
	        this.closingTime = closingTime;
	    }

	    public boolean preHandle(
	            HttpServletRequest request,
	            HttpServletResponse response,
	            Object handler) throws Exception {

	        Calendar cal = Calendar.getInstance();
	        int hour = cal.get(10);
	        if (openingTime <= hour && hour < closingTime) {
	            return true;
	        } else {
	            response.sendRedirect("http://host.com/outsideOfficeHours.html");
	            return false;
	        }
	    }
	    
	    /* (non-Javadoc)
	     * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	     */
	    @Override
	    public void afterCompletion(HttpServletRequest request,
	    		HttpServletResponse response, Object handler, Exception ex)
	    		throws Exception {
	    	// TODO Auto-generated method stub
	    	System.out.println("afterCompletion");
	    	super.afterCompletion(request, response, handler, ex);
	    }
	    
}
