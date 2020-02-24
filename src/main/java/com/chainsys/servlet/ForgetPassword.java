package com.chainsys.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.dao.RegistrationDAO;
import com.chainsys.exception.DbException;
import com.chainsys.registration.RegistrationImplementation;
import com.chainsys.Util.MailUtil1;

@WebServlet("/ForgetPassword")
public class ForgetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String emailId = (String)request.getParameter("emailid");
		HttpSession sec = request.getSession();
		sec.setAttribute("emailid", emailId);
		//System.out.println(emailId);http://192.168.56.205:8088/NewIndex.jsp
		MailUtil1.send("railt9740@gmail.com", "Railways123@",emailId, "TICKETS BOOKING STATUS", "http://192.168.56.205:8088/UpdatePassword.jsp");
		PrintWriter out = response.getWriter();
		out.println("Check your Email to Change your password");
	}

}
