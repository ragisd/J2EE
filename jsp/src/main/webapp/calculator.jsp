<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="calculator.jsp" method="post">
		<table>
			<tr>
				<td>Number 1 : </td>
				<td><input type="text" name="num1"></td>
			</tr>
			<tr>
				<td>Number 2 : </td>
				<td><input type="text" name="num2"></td>
			</tr>
			<tr>
				<td>operator : </td>
			</tr>
			<tr><td><input type="radio" name="operator" value="sum">+</td></tr>
			<tr><td><input type="radio" name="operator" value="sub">-</td></tr>
			<tr><td><input type="radio" name="operator" value="mul">*</td></tr>
			<tr><td><input type="radio" name="operator" value="div">/</td></tr>
		</table>
		<input type="submit" value="Result">		
	</form>
	
	<%! int num1, num2, result; %>
	<%
	
	String inp1 = request.getParameter("num1");
	String inp2 = request.getParameter("num2");
	String operator = request.getParameter("operator");
	
	if(inp1 != null && inp2 != null){
		
		num1 = Integer.parseInt(inp1);
		num2 = Integer.parseInt(inp2);
		
		if(operator.equals("sum")){
			result = num1 + num2;			
		}
		else if(operator.equals("sub")){
			result = num1 - num2;
		}
		else if(operator.equals("mul")){
			result = num1 * num2;
		}
		else {
			result = num1 / num2;
		}
	}
	%>
	<% if(result != 0) { %>
		<h1> Result : <%= result %> </h1>
	<% } %>
	
</body>
</html>