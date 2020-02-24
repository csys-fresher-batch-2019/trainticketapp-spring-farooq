package com.chainsys.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;  
  
import javax.servlet.http.HttpSession;
@WebServlet("/AdminLogin")

public class AdminLogin extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                    throws ServletException, IOException {  
    	
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        request.getRequestDispatcher("NewIndex.jsp").include(request, response);  
          
        String name=request.getParameter("login");  
        String password=request.getParameter("login");  
          
        if(password.equals("admin123")){  
        out.print("Welcome, "+name);  
        HttpSession session=request.getSession();  
        session.setAttribute("name",name);
        request.getRequestDispatcher("AdminIndex.jsp").forward(request, response);  

        }  
        else{  
            out.print("Sorry, username or password error!");  
            request.getRequestDispatcher("AdminLogin.jsp").include(request, response);  
        }  
        out.close();  
    }  
} 
