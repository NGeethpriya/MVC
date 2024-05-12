<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link rel="stylesheet" href="template.css">
</head>
<body>
	<%@ include file="Header.html"%>
	<br/><% String message = (String)request.getAttribute("message");
		if (message != null){%>
			<center style = "color : tomato; font-size : 20px; border : 2px solid SlateBlue; padding : 10px; border-radius : 10px;"><%=message %></center>
			<%}	%>
	<form action="register" method="post">
		<table style="padding: 30px; margin-top: 40px; height: 600px;">
			<tr>
				<td style="font-size: 25px;"><strong>NEW ACCOUNT</strong></td>
			</tr>
			<tr>
				<td><label>Name (Required)</label></td>
				<td><input type="text" name="firstname" required></td>
				<td><input type="text" name="lastname" required></td>
			</tr>
			<tr>
				<td></td>
				<td>First Name</td>
				<td>Last Name</td>
			</tr>
			<tr>
				<td><label>Address (Required)</label></td>
				<td><input type="text" name="addressline1" required></td>
				<td><input type="text" name="addressline2" required></td>
			</tr>
			<tr>
				<td></td>
				<td>Address Line 1</td>
				<td>Address Line 2</td>
			</tr>
			<tr>
				<td><label>City (Required)</label></td>
				<td><input type="text" name="city" required></td>
			</tr>
			<tr>
				<td><label>Phone (Required)</label></td>
				<td><input type="text" name="phone" required></td>
			</tr>
			<tr>
				<td><label>Email (Required)</label></td>
				<td><input type="text" name="email" required></td>
			</tr>
			<tr>
				<td><label>Password (Required)</label></td>
				<td><input type="password" id="password" name="password"
					required></td>
			</tr>
			<tr>
				<td><label>Confirm Password</label></td>
				<td><input type="password" id="cpassword" name="cpassword"
					required></td>
			</tr>
			<tr>
				<td><input type="submit" value="REGISTER"></input></td>
				<td></td>
				<td><a href = "Home.jsp">BACK</a></td>
			</tr>
		</table>
	</form>
	<%@ include file="Footer.html"%>
</body>
</html>