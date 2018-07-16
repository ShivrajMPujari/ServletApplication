package com.bridgeIt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgeIt.model.User;


/**
 * Servlet implementation class LogoutController
 */
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter write=response.getWriter();
		HttpSession session= request.getSession(false);
		Cookie cookies[]=request.getCookies();
		
		String userName = null;
		String JSessionId = null;
		Cookie login=null;
		for(Cookie cookie : cookies){
			
			if(cookie.getName().equals("user")){
				userName = cookie.getValue();
				login=cookie;
				break;
			}
			if (cookie.getName().equals("JSESSIONID")){JSessionId = cookie.getValue(); }
		}
		
		
		
		try {
			User user = (User)session.getAttribute("userObj");
			
			
			
			if (userName==null){
				//request.getRequestDispatcher("index.jsp").include(request, response);
				response.sendRedirect("index.jsp");
			}else {
				
				login.setMaxAge(0);
				response.addCookie(login);
				System.out.println(user.getEmail());
				session.setAttribute("userObj", null);
				session.invalidate();
				
				response.sendRedirect("index.jsp");
			}
		} catch (Exception e) {
			write.println("plz login first...");
			request.getRequestDispatcher("index.jsp").include(request, response);
		
		}
		
		
	}

}
