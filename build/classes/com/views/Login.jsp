<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="template.css">
</head>
<body>
	<%@ include file="Header.html"%>
	<% String data = (String)session.getAttribute("invalid");
	if (data!=null){%>
	<center style = "color : tomato; font-size : 20px; border : 2px solid SlateBlue; padding : 10px; border-radius : 10px;"><%=data %></center>
			<%}	%>
	
		<form action="product" method="post" >
			<table style = "width : 400px;">
				<tr>
					<td><label>Username*</label></td>
					<td><input type="text" name="uname" value = ""></input></td>
				</tr>
				<tr>
					<td><label>Password*</label></td>
					<td><input type="password" name="pword" value = ""></input></td>
				</tr>
				<tr>
					<td><a href = "Home.jsp">BACK</a> </td>
					<td><input type="submit" value="Login"></input></td>
				</tr>
			</table>
		</form>
	<%@ include file="Footer.html"%>
</body>
</html>