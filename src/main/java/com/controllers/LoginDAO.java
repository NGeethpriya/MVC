package com.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import com.models.ConnectDatabase;

@WebServlet("/product")
public class LoginDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConnectDatabase conData;
	private String fname;
	private HttpSession session;
	RequestDispatcher rdispatch;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pword = request.getParameter("pword");
		conData = new ConnectDatabase();
		session = request.getSession(true);
		fname = conData.validate(uname, pword);
		if (fname.equals("NoData")) {
			session.setAttribute("invalid","Invalid Username and Password. Try again");
			rdispatch = request.getRequestDispatcher("Login.jsp");
		}else {
		session.setAttribute("firstname", fname);
		rdispatch = request.getRequestDispatcher("Product.jsp");
		}
		rdispatch.forward(request, response);
	}
}
