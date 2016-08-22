<%@page import="com.bridgelabz.connection.FacebookConnection"%>
<%@page import="com.bridgelabz.connection.GoogleConnection"%>
<%@page import="com.bridgelabz.connection.LinkedInConnection"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	FacebookConnection facebook = new FacebookConnection();
%>
<%
	GoogleConnection google = new GoogleConnection();
%>
<%
	LinkedInConnection linkedin = new LinkedInConnection();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.2/js/bootstrap.min.js"></script>

<!-- font awesome css -->
<link
	href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css"
	rel="stylesheet">
</head>
<body style="text-align: center; padding: 1em">

	<center>
		<h1 style="color: #800000;">WELCOME TO MBAASBRIDGE</h1>
	</center>
	<center>
		<h2 style="color: black;">Sign in With Social Networks</h2>
	</center>
	<div class="btn-group">
		<a class='btn btn-danger disabled'><i class="fa fa-google-plus"
			style="width: 16px; height: 20px"></i></a> <a class='btn btn-danger'
			href='<%=google.getAuthUrl()%>' style="width: 12em;"> Sign in
			with Google</a>
	</div>
	<br />
	<br />
	<div class="btn-group">
		<a class='btn btn-primary disabled'><i class="fa fa-facebook"
			style="width: 16px; height: 20px"></i></a> <a class='btn btn-primary '
			href='<%=facebook.getAuthUrl()%>' style="width: 12em"> Sign in
			with Facebook</a>
	</div>
	<br />
	<br />
	<div class="btn-group">
		<a class='btn btn-info disabled'><i class="fa fa-twitter"
			style="width: 16px; height: 20px"></i></a> <a class='btn btn-info '
			href='' style="width: 12em"> Sign in with Twitter</a>
	</div>
	<br />
	<br />
	<div class="btn-group">
		<a class='btn btn-primary disabled'><i class="fa fa-linkedin"
			style="width: 16px; height: 20px"></i></a> <a class='btn btn-primary '
			href='<%=linkedin.getAuthUrl()%>' style="width: 12em"> Sign in
			with LinkedIn</a>
	</div>
	<br />
	<br />
</body>
</html>
