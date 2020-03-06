package com.chainsys.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.service.BookingService;

@WebServlet("/Booking")
public class Booking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int trainNumber = Integer.parseInt(request.getParameter("trainnumber"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		String SourceStation = request.getParameter("source");
		String destStation = request.getParameter("destination");
		int noOfSeats = Integer.parseInt(request.getParameter("NoOfSeats"));
		LocalDate date = LocalDate.parse((request.getParameter("Traveldate")));

		PrintWriter out = response.getWriter();
		BookingService obj = new BookingService();
		
		try {

			int amount = obj.bookSeats1(trainNumber, userId, SourceStation, destStation, noOfSeats, date);

			if (amount == 0) {
				out.println("your account is blocked Please Contact Us");
			} else

				response.sendRedirect("payment.jsp?amount=" + amount);

		} catch (Exception e) {
			out.println("YOU CANT BOOK MORE SEATS ON SAME DAY ON SAME TRAIN .BOOK MAXIMUN 5 SEATS ON EACH BOOKINGS "
					+ e.getMessage());

		}

	}

}
