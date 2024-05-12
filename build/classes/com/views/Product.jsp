<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<%@ include file="Header.html"%>
	<form action="info" method="get">
		<table>
		<%String firstname = (String)session.getAttribute("firstname"); %>
		<tr>
				<td colspan = "2"><h2>Welcome <%=firstname %>!</h2></td>
			</tr>
		
		<tr>
				<td>Enter Product ID</td>
				<td><input type="text" name="pid"></td>
			</tr>
			<tr>
				<td><input type="submit" value="SUBMIT"></td>
				<td><a href="Home.jsp">LOG OUT</a></td>
			</tr>
		</table>
	</form>

	<%@ include file="Footer.html"%>
</body>
</html>