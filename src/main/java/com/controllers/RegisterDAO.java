package com.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.models.ConnectDatabase;

@WebServlet("/register")
public class RegisterDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String fname, lname, add1, add2, city, phone, email, password, cpassword;
	int pno;
	private ConnectDatabase conData;
	RequestDispatcher rdispatch = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		fname = request.getParameter("firstname");
		lname = request.getParameter("lastname");
		add1 = request.getParameter("addressline1");
		add2 = request.getParameter("addressline2");
		city = request.getParameter("city");
		phone = request.getParameter("phone");
		pno = Integer.parseInt(phone);
		email = request.getParameter("email");
		password = request.getParameter("password");
		cpassword = request.getParameter("cpassword");
		if ((!password.equals(cpassword))) {
			request.setAttribute("message", "Passwords do not match. Try again.");
			rdispatch = request.getRequestDispatcher("Register.jsp");
		} 
		if (password.equals(cpassword)){
			conData = new ConnectDatabase();
			String insert = conData.insert(fname, lname, add1, add2, city, pno, email, password);
			if (insert.equals("Duplicate")) {
				request.setAttribute("message", "Email already exists. Try again");
				rdispatch = request.getRequestDispatcher("Register.jsp");
			}else {
			request.setAttribute("message", insert);
			rdispatch = request.getRequestDispatcher("Success.jsp");
			}
		}
		rdispatch.forward(request, response);
	}
}
