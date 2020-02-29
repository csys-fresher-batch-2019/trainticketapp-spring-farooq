package com.chainsys.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.dao.impl.Bookingimplements;
import com.chainsys.exception.DbException;

@WebServlet("/DisplayName")
public class DisplayName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int user_id = Integer.parseInt(request.getParameter("userid"));
		HttpSession sec = request.getSession();
		Bookingimplements obj = new Bookingimplements();
		String name;
		try {
			name = obj.getUserName(user_id);
			sec.setAttribute("name", name);
			response.sendRedirect("/NewIndex.jsp");
		} catch (DbException e) {
			e.printStackTrace();
		}
		
	}

	

}
