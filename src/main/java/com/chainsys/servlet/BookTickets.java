package com.chainsys.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.dao.impl.Bookingimplements;
import com.chainsys.service.BookingService;

@WebServlet("/BookTickets")
public class BookTickets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		

		int trainNumber =Integer.parseInt(request.getParameter("trainnum"));
		System.out.println(trainNumber);
		int userId = Integer.parseInt(request.getParameter("userId"));
		System.out.println(userId);
		String SourceStation=request.getParameter("source");
		System.out.println(SourceStation);
		String destStation=request.getParameter("destination");
		System.out.println(destStation);
		int noOfSeats=Integer.parseInt(request.getParameter("NoOfSeats"));
		System.out.println(noOfSeats);
		String date1=(request.getParameter("Traveldate"));
		LocalDate date = LocalDate.parse(date1);
		
		System.out.println(date);
		
//		Bookingimplements obj = new Bookingimplements();
		BookingService obj = new BookingService();

		try {
			obj.bookSeats1(trainNumber, userId, SourceStation, destStation, noOfSeats, date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
