<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.order.JavaBeans.ProductBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Details</title>
<link rel="stylesheet" href="template.css">
</head>
<style>
td, th {
	border: 1px solid SlateBlue;
	padding: 5px;
}
</style>
<body>
	<%@ include file="Header.html"%>

	<table>
	<%
		ProductBean productBean = (ProductBean) request.getAttribute("productBean");
		%>
	
	<tr>
		<td colspan=" 4" style="font-size: 25px; text-transform: uppercase;"><strong><%=productBean.getProductName()%></strong></td>
		</tr>
		<tr>
			<th>PRODUCT ID</th>
			<th>PRODUCT NAME</th>
			<th>PURCHASE DATE</th>
			<th>PRICE</th>
		</tr>
		<tr>

			<td><%=productBean.getProductId()%></td>
			<td><%=productBean.getProductName()%></td>
			<td><%=productBean.getPurchaseDate()%></td>
			<td><%=productBean.getPrice()%></td>
		</tr>
	</table>
	<br>
	<center>
		<a href="Product.jsp">BACK</a>
	</center>

	<%@ include file="Footer.html"%>
</body>
</html>