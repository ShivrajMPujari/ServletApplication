package com.bridgeIt.LoginReg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgeIt.LoginReg.DAO.UserDAO;
import com.bridgeIt.UserPojo.User;

/**
 * Servlet implementation class UserLogin
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String email=request.getParameter("emailId");
		String password = request.getParameter("password");
		
		System.out.println(email+" "+password);
		
		UserDAO dao= new UserDAO();
		ResultSet set=dao.logIn(email, password);
		System.out.println(set);
		try {
			set.next();
			HttpSession session=request.getSession();
			User user = new User();
			user.setEmail(set.getString("email"));
			user.setFullName(set.getString("fullName"));
			user.setPassword(set.getString("password"));
			user.setUserName(set.getString("userName"));
			session.setAttribute("user", user);
			request.getRequestDispatcher("UserHome.jsp").forward(request, response);
		System.out.println(set.getString("email")+" "+set.getString("userName")+" "+set.getString("fullName"));	
		} catch (SQLException e) {
			response.setContentType("text/html");
			PrintWriter write=response.getWriter();
			write.println("Wrong email or Password entered");
			request.getRequestDispatcher("index.html").include(request, response);
			e.printStackTrace();
		}
		
		
	}

}
