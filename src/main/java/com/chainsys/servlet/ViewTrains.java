package com.chainsys.servlet;

import java.awt.Window;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.viewtrains.ListTrain;
import com.chainsys.viewtrains.ViewTrainsimplementation;

/**
 * Servlet implementation class ViewTrains
 */
@WebServlet("/ViewTrains")
public class ViewTrains extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ViewTrainsimplementation obj = new ViewTrainsimplementation();

		PrintWriter out = response.getWriter();

		String BoardingStation = request.getParameter("source");
		System.out.println(BoardingStation);
		String DestinationStation = request.getParameter("destination");
		System.out.println(DestinationStation);
		LocalDate traveldate = LocalDate.parse(request.getParameter("Traveldate"));
		System.out.println(traveldate);
		HttpSession session = request.getSession();
		session.setAttribute("traveldate", traveldate);
		session.setAttribute("source", BoardingStation);
		session.setAttribute("destination", DestinationStation);

		try {

			ArrayList<ListTrain> task = obj.getTrainDetails(BoardingStation, DestinationStation, traveldate);
			System.out.println("Size:" + task.size());
			System.out.println(task);
			
			request.setAttribute("trains", task);
			RequestDispatcher request1 = request.getRequestDispatcher("/NewIndex.jsp");
			request1.forward(request, response);

			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
