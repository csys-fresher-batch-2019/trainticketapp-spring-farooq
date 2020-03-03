package com.chainsys.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.dao.impl.Bookingimplements;
import com.chainsys.exception.DbException;
import com.chainsys.service.BookingService;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		int userid = Integer.parseInt(request.getParameter("userid"));
		String password = request.getParameter("password");
		
//		Bookingimplements obj = new Bookingimplements();
		BookingService obj = new BookingService();

		try {
			boolean result=obj.login(userid, password);
			if(result==true) {
				out.println("LOGGED IN");
				
				session.setAttribute("userid", userid);
				Bookingimplements obj1 = new Bookingimplements();
				String name;
				try {
					name = obj1.getUserName(userid);
					System.out.println(name);
					session.setAttribute("name", name);
					RequestDispatcher request1 = request.getRequestDispatcher("NewIndex.jsp");
					request1.forward(request, response);
				} catch (DbException e) {
					e.printStackTrace();
				}
				
			}else {
request.setAttribute("errorMsg","Invalid User-id or Password");
RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
rd.forward(request, response); 

			}
			
				
			}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
