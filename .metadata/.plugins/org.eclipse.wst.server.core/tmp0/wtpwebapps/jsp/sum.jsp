<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="sum.jsp" method="post">
		<table>
			<tr>
				<td>Number 1 : </td>
				<td><input type="number" name="num1"></td>
			</tr>
			<tr>
				<td>Number 2 : </td>
				<td><input type="number" name="num2"></td>
			</tr>
		</table>
		<input type="submit" value="Add">		
	</form>

	<%! int num1, num2, sum; %>
	<%
	
	String inp1 = request.getParameter("num1");
	String inp2 = request.getParameter("num2");
	
	if(inp1 != null && inp2 != null){
		num1 = Integer.parseInt(inp1);
		num2 = Integer.parseInt(inp2);
		sum = num1 + num2;
	}
	%>
	
	<%= sum %>
	
</body>
</html>
