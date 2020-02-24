package com.chainsys.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.exception.DbException;
import com.chainsys.seats.Seats;
import com.chainsys.seats.Seatsimplementation;

@WebServlet("/UpdateSeats")
public class UpdateSeats extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int trainNumber = Integer.parseInt(request.getParameter("trainnum"));
		int seatsCount = Integer.parseInt(request.getParameter("seatcount"));
		String date = request.getParameter("traveldate");
		LocalDate date1 = LocalDate.parse(date);

		Seatsimplementation obj = new Seatsimplementation();
		Seats obj1 = new Seats();
		obj1.setAvailableseats(seatsCount);
		obj1.setTrainnumber(trainNumber);
		obj1.setTravelDate(date1);
		PrintWriter out = response.getWriter();
		try {
			int result=obj.updateSeatsCount(obj1);
			if(result==0) {
				request.setAttribute("errormss", "INVALID DATA ENTERED");
				RequestDispatcher req = request.getRequestDispatcher("/UpdateSeatsCount.jsp");
				req.forward(request, response);
			}else {
				request.setAttribute("errormss", "SEATS COUNT UPDATED");
				RequestDispatcher req = request.getRequestDispatcher("/UpdateSeatsCount.jsp");
				req.forward(request, response);
			}
		
		} catch (DbException e) {
			e.printStackTrace();
		}
	}

}
