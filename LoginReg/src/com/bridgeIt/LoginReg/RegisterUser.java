package com.bridgeIt.LoginReg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgeIt.LoginReg.DAO.UserDAO;
import com.bridgeIt.UserPojo.User;

/**
 * Servlet implementation class RegisterUser
 */
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter write=response.getWriter();
		User user = new User();
		UserDAO userDAO = new UserDAO();
		
		user.setEmail(request.getParameter("email"));
		user.setFullName(request.getParameter("fullName"));
		user.setPassword(request.getParameter("pass1"));
		user.setUserName(request.getParameter("userName"));
		
		try {
			boolean result = userDAO.insertUser(user);
			
			if(result){
				write.println("you are registerd plz login..");
				request.getRequestDispatcher("index.html").include(request, response);
			}
			else if (result==false){
				
				write.println("something went wrong plz register again");
				request.getRequestDispatcher("index.html").include(request, response);
			}
			
		} catch (Exception e) {
			write.println("something went wrong plz register again");
			request.getRequestDispatcher("index.html").include(request, response);
			e.printStackTrace();
		}
		
	}

}
