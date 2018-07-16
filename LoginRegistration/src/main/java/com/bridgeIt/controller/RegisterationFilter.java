package com.bridgeIt.controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class RegisterationFilter
 */
public class RegisterationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public RegisterationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		
		String email = request.getParameter("emailId");
		String pass1 = request.getParameter("pass1");
		String pass2 = request.getParameter("pass2");
		String fullName	= request.getParameter("fullName");
		String userName =request.getParameter("userName");
		
		final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

		Pattern pattern = Pattern.compile(EMAIL_REGEX);
		Matcher matcher = pattern.matcher(email);
		boolean result= matcher.matches();
		
		if(result && pass1.equals(pass2) && fullName.length()>1 && userName.length()>4) {
			chain.doFilter(request, response);
		}else {
			
			System.out.println(result);
			System.out.println(email+"---"+ pass1+"--"+pass2+" "+fullName+" "+userName);
			HttpServletResponse res=(HttpServletResponse)response;
			res.sendRedirect("index.jsp");
		}

		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
