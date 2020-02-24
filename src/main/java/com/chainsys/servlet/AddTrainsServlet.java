package com.chainsys.servlet;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.exception.DbException;
import com.chainsys.viewtrains.ListTrain;
import com.chainsys.viewtrains.ViewTrainsimplementation;

@WebServlet("/AddTrainsServlet")
public class AddTrainsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int trainnumber = Integer.parseInt(request.getParameter("trainnumber"));
		String trainname = request.getParameter("trainname");
		LocalDate traveldate = LocalDate.parse(request.getParameter("traveldate"));
		String boardingstation = request.getParameter("source");
		String destinationstation = request.getParameter("dest");
		String arrivaltime = request.getParameter("arrivaltime");
		String depttime = request.getParameter("depttime");
		String route = request.getParameter("route");
		String status = request.getParameter("status");
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		
		ViewTrainsimplementation obj = new ViewTrainsimplementation();
		ListTrain It = new ListTrain();
		try {
			It.setTrainnumber(trainnumber);
			It.setTrainname(trainname);
			It.setDate(traveldate);
			It.setBoardingstation(boardingstation);
			It.setDestinationstation(destinationstation);
			It.setArrivaltime(arrivaltime);
			It.setDepaturetime(depttime);
			It.setRoute(route);
			It.setStatus(status);
			It.setAmount(amount);
			
			obj.insertnewTrain(It);
		} catch (DbException e) {
			e.printStackTrace();
		}
	
	}

}
