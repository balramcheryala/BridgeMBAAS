<%@page import="com.javapapers.java.social.facebook.TWConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	TWConnection fbConnection = new TWConnection();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Java</title>
</head>
<body style="text-align: center; margin: 0 auto;">
	
		<a href="<%=fbConnection.getFBAuthUrl()%>"> <img
			src="./img/linkedin_button.png" />
		</a>


</body>
</html>