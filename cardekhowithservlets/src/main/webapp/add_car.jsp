<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

	<style type="text/css">
		body{
			background-color: beige;
		}
	</style>	
</head>
<body>
	<form action="addCar" method="post">
		<table border="solid">
			<tr>
				<td>Id : </td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>Name : </td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Brand :</td>
				<td><input type="text" name="brand"></td>
			</tr>
			<tr>
				<td>Price : </td>
				<td><input type=text name="price"></td>
			</tr>
		</table>
		<input type="submit" value="Add Car">
	</form>
	
	<%! String message; %>
	<% message = request.getParameter("message"); %>
	
	
	
</body>
</html>