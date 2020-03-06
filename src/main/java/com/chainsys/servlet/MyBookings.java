package com.chainsys.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.exception.DbException;
import com.chainsys.exception.SqlException;
import com.chainsys.model.Booking;
import com.chainsys.service.BookingService;

@WebServlet("/MyBookings")
public class MyBookings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
//int user_id = Integer.parseInt(request.getParameter("user_id"));
		HttpSession session = request.getSession();
		int user_id = (int)session.getAttribute("userid");

		//Bookingimplements obj = new Bookingimplements();
		
		BookingService obj = new BookingService();

		try {
			
			ArrayList<Booking> task=obj.myBooking(user_id);
			request.setAttribute("booklist", task);
			RequestDispatcher request1 = request.getRequestDispatcher("/Mybookings.jsp");
			request1.forward(request, response);
			for (Booking booking : task) {
				System.out.println(booking);
			}
			
		} catch (DbException | SqlException e) {
			e.printStackTrace();
		}
		
		
	}

	

}
