package com.chainsys.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.booking.Bookingimplements;
import com.chainsys.dao.RegistrationDAO;
import com.chainsys.exception.DbException;
import com.chainsys.registration.RegistrationImplementation;
import com.chainsys.Util.MailUtil1;

@WebServlet("/UpdatePassword")
public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password1 = request.getParameter("password1");
	

		String emailid=(request.getParameter("emailid"));
		//System.out.println(emailid);
		try {
		
		String password2 = request.getParameter("password2");
		if(password1.equals(password2)) {
		RegistrationDAO obj = new RegistrationImplementation();
		try {
			obj.changePassword(emailid, password1);

			response.sendRedirect("Login.jsp");
		} catch (DbException e) {
			e.printStackTrace();
		}
		
		}else {
			PrintWriter out = response.getWriter();
			//out.println("PASSWORD DOES NOT MATCH");
		}
	}catch(Exception e){
		e.printStackTrace();
	}

	}
}
