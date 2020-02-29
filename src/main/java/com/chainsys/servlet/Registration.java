package com.chainsys.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.Util.MailUtil1;
import com.chainsys.dao.impl.RegistrationImplementation;
import com.chainsys.exception.DbException;

@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String UserName = request.getParameter("username");
		 String email = request.getParameter("email");
		 String password = request.getParameter("password");
		 String pass=request.getParameter("conpassword");
		 long phonenumber = Long.parseLong(request.getParameter("phonenumber"));
		 String gender = request.getParameter("gender");
		 LocalDate dob = LocalDate.parse(request.getParameter("dob"));
		 String city = request.getParameter("city");
		 
		 if(password.equals(pass)) {

         
        	 RegistrationImplementation obj = new  RegistrationImplementation();
    		 try {
    			int UserId=obj.registrationInsert(UserName, password, email, phonenumber, gender, dob, city);
    			//request.setAttribute("userid", UserId);
    			MailUtil1.send("railt9740@gmail.com", "Railways123@",email, "TICKETS BOOKING STATUS", "USER ID="+UserId);
    			 request.getRequestDispatcher("/NewIndex.jsp?").forward(request, response);

    		} catch (DbException e) {
    			e.printStackTrace();
    		}
    		
    		 } else{
    			 
             request.setAttribute("errorMessage", "Password Does not match ");
             RequestDispatcher rd = request.getRequestDispatcher("/Registration.jsp");
             rd.forward(request, response);   
            
         }
                
		 
		 
		 
		 
		 
		 
		 if(password.equals(pass)) {
			 
		 
		 RegistrationImplementation obj = new  RegistrationImplementation();
		 try {
			int UserId=obj.registrationInsert(UserName, password, email, phonenumber, gender, dob, city);
			request.setAttribute("userid", UserId);
			 request.getRequestDispatcher("/NewIndex.jsp?").forward(request, response);

		} catch (DbException e) {
			PrintWriter out = response.getWriter();
			out.println("User Already Registered");
		}
		
		 }else {
			 PrintWriter out = response.getWriter();
			 out.println("PASSWORD DOESNOT MATCH");
			 response.sendRedirect("Registration.jsp");
			 			 
		 }
		 }

	}
