package com.chainsys.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.dao.impl.ViewTrainsimplementation;

@WebServlet("/NewIndex")
public class NewIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at:hello ").append(request.getContextPath());

		ViewTrainsimplementation obj = new ViewTrainsimplementation();
		try {
			ArrayList<String> list1=obj.getTrainDetailsByBoardingStation();
			request.setAttribute("source", list1);
RequestDispatcher req = request.getRequestDispatcher("NewIndex.jsp");
req.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}


}
