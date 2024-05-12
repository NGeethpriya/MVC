package com.controllers;

import com.models.ConnectDatabase;
import com.order.JavaBeans.ProductBean;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/info")
public class RetrieveProductDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConnectDatabase conData;
	private RequestDispatcher rdispatch = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String productId = request.getParameter("pid");
		conData = new ConnectDatabase();
		ProductBean productBean = conData.retrieve(productId);
		if (productBean != null) {
			request.setAttribute("productBean", productBean);
			rdispatch = request.getRequestDispatcher("ViewProductDetails.jsp");
			rdispatch.forward(request, response);
		} else {
			response.sendRedirect("Error.jsp");
		}
	}

}
