package com.chainsys.servlet;

import java.io.IOException;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.exception.DbException;
import com.chainsys.Util.MailUtil1;
import com.chainsys.dao.impl.Bookingimplements;
@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		String MerchantId =request.getParameter("merchantid");
		long Mobilenumber =Long.parseLong(request.getParameter("mobileno"));
		float Amount=Float.parseFloat(request.getParameter("amount"));
		//System.out.println(Mobilenumber1 +  "-"+Mobilenumber2 +"-"+Amount );
		String result="Transaction Successfull";
//
//		ImplementTransactionDetails obj=new ImplementTransactionDetails();
//		EmailConfirmation obj1=new EmailConfirmation();
//		try {
//		result=obj.merchantTransaction(MerchantId, Mobilenumber, Amount);
//		if(result.equals("Transaction Successfull")) {
//		}
//		} catch (Exception e) {
//		e.printStackTrace();
//		}
		String emailId=null;
		HttpSession session = request.getSession();
		int userId = (int)session.getAttribute("userid");
		Bookingimplements obj = new Bookingimplements();
		try {
			emailId=obj.getemailId(userId);
		} catch (DbException e1) {
			//response.sendRedirect("/Login.jsp");
			
		}
		
		
		MailUtil1.send("railt9740@gmail.com", "Railways123@",emailId, "TICKETS BOOKING STATUS", "SUCCESSFULLY BOOKED \n AMOUNT PAID='"+Amount+"'");	
		String url=request.getParameter("redirect_url");
		System.out.println(url);
		String param = "?status="+ result;
		response.sendRedirect(url+param);
	}

}
