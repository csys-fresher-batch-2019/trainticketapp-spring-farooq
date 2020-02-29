package com.chainsys.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.exception.DbException;
import com.chainsys.Util.MailUtil1;
import com.chainsys.dao.impl.Bookingimplements;
@WebServlet("/Booking")
public class Booking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int trainNumber = Integer.parseInt(request.getParameter("trainnumber"));
		System.out.println(trainNumber);
		int userId = Integer.parseInt(request.getParameter("userId"));
		System.out.println(userId);
		String SourceStation = request.getParameter("source");
		System.out.println(SourceStation);
		String destStation = request.getParameter("destination");
		System.out.println(destStation);
		int noOfSeats = Integer.parseInt(request.getParameter("NoOfSeats"));
		System.out.println(noOfSeats);
		LocalDate date = LocalDate.parse((request.getParameter("Traveldate")));
		System.out.println(date);
	
		PrintWriter out = response.getWriter();
		Bookingimplements obj = new Bookingimplements();
		
		

		try {
			
			int amount=obj.bookSeats1(trainNumber, userId, SourceStation, destStation, noOfSeats, date);
			

System.out.println(amount);

if(amount==0) {
				out.println("your account is blocked Please Contact Us");
			}
			else
			response.sendRedirect("payment.jsp?amount="+amount);

			
		} catch (Exception e) {
			//out.println("YOU CANT BOOK MORE SEATS ON SAME DAY ON SAME TRAIN\n USER CN ONLY BOOK MAXIMUN 5 SEATS ON EACH BOOKINGS ");
			e.printStackTrace();
		}

	}

}
