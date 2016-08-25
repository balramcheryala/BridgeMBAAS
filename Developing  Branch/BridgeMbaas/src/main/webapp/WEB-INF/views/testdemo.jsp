<%@page import="com.bridgelabz.connection.FacebookConnection"%>
<%@page import="com.bridgelabz.connection.GoogleConnection"%>
<%@page import="com.bridgelabz.connection.LinkedInConnection"%>
<%@page import="com.bridgelabz.connection.GitHubConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	FacebookConnection facebook = new FacebookConnection();
%>
<%
	GoogleConnection google = new GoogleConnection();
%>
<%
	LinkedInConnection linkedin = new LinkedInConnection();
%>
<%
	GitHubConnection github = new GitHubConnection();
%>
<html>
<title>${title}</title>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>
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

<body>
	<center>
		<br /> <br />
		<div class="btn-group">

			<a class='btn btn-info disabled'><i class="fa fa-gittip"
				style="width: 20px; height: 20px"></i></a> <a class='btn btn-info'
				href='#' style="width: 90em;"> Testing Purpose Only</a>
		</div>
		<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
		<div class="btn-group">
			<a class='btn btn-danger disabled'><i class="fa fa-google-plus"
				style="width: 16px; height: 20px"></i></a> <a class='btn btn-danger'
				href='<%=google.getAuthUrl()%>' style="width: 12em;"> Sign in
				with Google</a>
		</div>
		<br /> <br />
		<div class="btn-group">
			<a class='btn btn-primary disabled'><i class="fa fa-facebook"
				style="width: 16px; height: 20px"></i></a> <a class='btn btn-primary '
				href='<%=facebook.getAuthUrl()%>' style="width: 12em"> Sign in
				with Facebook</a>
		</div>
		<br /> <br />
		<div class="btn-group">
			<a class='btn btn-default disabled'><i class="fa fa-github"
				style="width: 16px; height: 20px"></i></a> <a class=' btn btn-default'
				href='<%=github.getAuthUrl()%>' style="width: 12em"> Sign in
				with GitHub</a>
		</div>
		<br /> <br />
		<div class="btn-group">
			<a class='btn btn-primary disabled'><i class="fa fa-linkedin"
				style="width: 16px; height: 20px"></i></a> <a class='btn btn-primary '
				href='<%=linkedin.getAuthUrl()%>' style="width: 12em"> Sign in
				with LinkedIn</a>
		</div>
		<br /> <br />
		<div class="btn-group">
			<a class='btn btn-info'><i class="fa fa-twitter"
				style="width: 16px; height: 20px"></i></a> <a class='btn btn-info '
				href='/bridgembaas/signin' style="width: 12em"> Sign in with
				Twitter</a>
		</div>
		<br /> <br />
	</center>
</body>
</html>
