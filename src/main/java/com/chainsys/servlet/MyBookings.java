package com.chainsys.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.TestConnect;
import com.chainsys.booking.Booking;
import com.chainsys.booking.Bookingimplements;
import com.chainsys.exception.DbException;

@WebServlet("/MyBookings")
public class MyBookings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
//int user_id = Integer.parseInt(request.getParameter("user_id"));
		HttpSession session = request.getSession();
		int user_id = (int)session.getAttribute("userid");

		Bookingimplements obj = new Bookingimplements();
		try {
			
			ArrayList<Booking> task=obj.myBooking(user_id);
			request.setAttribute("booklist", task);
			RequestDispatcher request1 = request.getRequestDispatcher("/Mybookings.jsp");
			request1.forward(request, response);
			for (Booking booking : task) {
				System.out.println(booking);
			}
			
		} catch (DbException e) {
			e.printStackTrace();
		}
		
		
	}

	

}
