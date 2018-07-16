package com.bridgeIt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgeIt.model.User;
import com.bridgeIt.service.Service;


/**
 * Servlet implementation class RegistrationController
 */
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter write=response.getWriter();
		User user = new User();
		Service service = new Service();
		user.setEmail(request.getParameter("emailId"));
		user.setFullName(request.getParameter("fullName"));
		user.setPassword(request.getParameter("pass1"));
		user.setUserName(request.getParameter("userName"));
		
		System.out.println(user);
		boolean outcome = service.userExistence(user);
	
		if (outcome) {
			String warning = "you are an existing user";
			HttpSession session=request.getSession();
			session.setAttribute("warning", warning);
			request.getRequestDispatcher("Registration.jsp").include(request, response);
			
		}else{

		try {
			boolean result = service.userRegister(user);
			
			if(result){
				
				String warning = "you are registerd plz login..";
				HttpSession session=request.getSession();
				request.setAttribute("warning", warning);
				request.getRequestDispatcher("index.jsp").include(request, response);
			}
			else if (result==false){
				
				String warning = "something went wrong plz register again";
				HttpSession session=request.getSession();
				request.setAttribute("warning", warning);
				request.getRequestDispatcher("index.jsp").include(request, response);
			}
			
		} catch (Exception e) {
			String warning = "something went wrong plz register again";
			HttpSession session=request.getSession();
			session.setAttribute("warning", warning);
			request.getRequestDispatcher("index.jsp").include(request, response);
			e.printStackTrace();
		}
			
		
		}
	}

}
