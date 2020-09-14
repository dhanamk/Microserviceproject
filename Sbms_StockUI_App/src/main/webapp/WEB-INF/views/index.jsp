<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Get Stock price here :: ${msg}</h3>
	
	<form action="getTotalCost">
		<table>
			<tr>
				<td>Company Name</td>
				<td><input type="text" name="companyName"></td>
			</tr>

			<tr>
				<td>Quantity</td>
				<td><input type="text" name="qty"></td>
			</tr>

			<tr>
				<td><input type="submit" value="Get Cost"></td>
			</tr>
		</table>
	</form>
</body>
</html>