package com.chainsys.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chainsys.exception.DbException;
import com.chainsys.service.RegisterUserService;
@WebServlet("/BlockUser")
public class BlockUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	int userId = Integer.parseInt(request.getParameter("userid"));
	int Status = Integer.parseInt(request.getParameter("block"));
	RegisterUserService obj1 = new RegisterUserService();
	try {
		int result=obj1.blockUser(userId, Status);
		
		if(result==1) {
			
		request.setAttribute("info", "Processed");	
		RequestDispatcher req = request.getRequestDispatcher("BlockUser.jsp");
		req.forward(request, response);
		
		}else {
			request.setAttribute("info", "Invalid UserId");
			RequestDispatcher req = request.getRequestDispatcher("BlockUser.jsp");
			req.forward(request, response);
		}
		
	} catch (DbException e) {
		e.printStackTrace();
	}
	
	
	
	}

}
