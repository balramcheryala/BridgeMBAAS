<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>${title}</title>
<head>
<style type="text/css">
body {
	background-size: cover;
}
</style>
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
</head>
<body BACKGROUND="<c:url value='/resources/images/back.jpg'/> " />
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-envelope"></span>
			</button>
			<a class="navbar-brand" href="">${name}</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">


			<form class="navbar-form navbar-left" role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Find apps">
				</div>
				<button type="submit" class="btn btn-info">Go</button>
			</form>
			<form class="nav navbar-nav navbar-right"
				name='GoogleSocialloginForm'
				action="<c:url value='../auth/google' />" method='POST'>
				<button type="submit" class="btn btn-info">Sign In with
					Google</button>
				<input type="hidden" name="scope"
					value="https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/userinfo#email https://www.googleapis.com/auth/plus.me https://www.googleapis.com/auth/tasks https://www-opensocial.googleusercontent.com/api/people https://www.googleapis.com/auth/plus.login" />
				<div class="clear"></div>
			</form>
		</div>
	</div>
	<%-- 			<!-- /.container-fluid -->
	</nav>
	<form class="login_form" name='loginForm'
		action="<c:url value='../j_spring_security_check' />" method='POST'>
		<ul>
			<li><input type="text" class="textbox1" id="username"
				name="j_username" placeholder="Username" required="">
				<p>
					<img src="../images/contact.png" alt="">
				</p></li>
			<li><input type="password" id="password" name="j_password"
				class="textbox2" placeholder="Password">
				<p>
					<img src="../images/lock.png" alt="">
				</p></li>
		</ul>
		<input type="submit" name="Sign In" value="Sign In">
		<div class="clear"></div>
		<label class="checkbox"><input type="checkbox" name="checkbox"
			checked=""><i></i>Remember me</label>
		<div class="forgot">
			<a href="#">forgot password?</a>
		</div>
		<div class="clear"></div>
	</form>
	<c:url value="../services/signup" var="signupurl" />
	<div class="account">
		
		<div class="span">
			<form name='facebookSocialloginForm'
				action="<c:url value='../auth/facebook?scope=email,user_about_me,user_birthday' />"
				method='POST'>
				<img src="../images/facebook.png" alt="">
				<button type="submit">
					<i>Sign In with Facebook</i>
				</button>
				<div class="clear"></div>
			</form>
		</div>
		<div class="span1">
			<form name='TwitterSocialloginForm'
				action="<c:url value='../auth/twitter?scope=email,user_about_me,user_birthday' />"
				method='POST'>
				<button type="submit">
					<i>Sign In with Twitter</i>
				</button>
				<div class="clear"></div>
			</form>
		</div>
		<div class="span2">
			<form name='LinkedInSocialloginForm'
				action="<c:url value='../auth/linkedin' />" method='POST'>
				<img src="../images/linkedin.png" alt="">
				<button type="submit">
					<i>Sign In with Linkedin</i>
				</button>
				<div class="clear"></div>
			</form>
		</div>
	</div> --%>
	</body>
</html>
