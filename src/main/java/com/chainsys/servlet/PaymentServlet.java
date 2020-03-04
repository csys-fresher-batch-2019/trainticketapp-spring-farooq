package com.chainsys.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.exception.DbException;
import com.chainsys.exception.SqlException;
import com.chainsys.Util.MailUtil1;
import com.chainsys.client.WalletAPI;
import com.chainsys.dao.impl.Bookingimplements;

@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		float Amount = Float.parseFloat(request.getParameter("amount"));
		String merchantId = request.getParameter("merchantId");
		long mobileNo = Long.parseLong(request.getParameter("mobileNo"));


		String result="failed";

		PrintWriter out = response.getWriter();
out.println("hi");
		String emailId = null;
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userid");
		
		Bookingimplements obj = new Bookingimplements();
		
		try {
			emailId = obj.getemailId(userId);
			MailUtil1.send("railt9740@gmail.com", "Railways123@", emailId, "TICKETS BOOKING STATUS",
					"SUCCESSFULLY BOOKED \n AMOUNT PAID='" + Amount + "'");
			String url = request.getParameter("redirect_url");
			System.out.println(url);
			String param = "?status=" + result;
			response.sendRedirect(url + param);
		} catch (DbException e1) {

		} catch (SqlException e) {
			e.printStackTrace();
		}

		
	}

}
