<%@page import="java.awt.geom.Path2D"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form action="palindrome.jsp" method="post">
		<table>
			<tr>
				<td>Enter the String : </td>
				<td><input type="text" name="num1"></td>
			</tr>
		</table>
		<input type="submit" value="Check">		
	</form>
	
	<%! String str = "";
	int flag = 0;
	char[] arr;
	String str2 = "";
	
	%>
	<%	
	str = request.getParameter("num1");
	if(str != null){
		arr = str.replace("\\s+", "").toCharArray();	
	}	
	%>
	
	<% 
	if(arr != null){
		for(int i = arr.length - 1; i >= 0; i--){
			str2 += arr[i];
		}
		%>
		
		<h1><%=str2%></h1>
		
		<%
		if(str2.equals(str)){
			flag = 1;
		}
		%>
	<%if(flag == 1){ %>
		<h2> <%=str %> is palindrome string</h2>
		
	<% }
	else {%>
		<h2><%=str %> is not a palindrome string</h2>	
	<% }
	 
	 }%>
	 
	 
	
	
</body>
</html>