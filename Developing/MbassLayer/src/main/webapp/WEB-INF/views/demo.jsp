<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="java.util.logging.Logger"%>
<html>
<head>
<title>Popup contact form</title>
<!-- <link href="css/elements.css" rel="stylesheet"> -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/elements.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap.min.css" />" />
<script type="text/javascript"
	src="<c:url value="/resources/js/my_js.js" />"></script>
</head>
<!-- Body Starts Here -->
<body id="body" style="overflow: hidden;" bgcolor="FloralWhite">
	<style>
body {
	background-color: FloralWhite;
	margin: 48px 0px 0px 64px;
}

div#topdiv {
	position: fixed;
	top: 0px;
	left: 0px;
	width: 100%;
	color: white;
	background: DarkMagenta ;
	padding: 10px;
}
</style>
	<div id="xyz">
		<div id="topdiv">
			<img src="<c:url value="resources/images/bridgelabz.png" />" alt=" "
				style="width: 100px; height: 24px;"><strong>BridgeLabz</strong>
		</div>
		<div id="container">
			<header></header>
			<main>
			<section class="half"></section>
			<section class="half"></section>
			</main>
		</div>

		<br>
		<center>
			<h1 class="main">
				<font color=navy>WELCOME TO BridgeMbaaS Layer...!</font>
			</h1>
		</center>
		<!-- <div class="col-sm-6"> -->
		<br>
		<center>
			<button id="popup" onclick="div_show()">
				<h2 class="new_project">CREATE NEW PROJECT</h2>
			</button>
		</center>
		<!-- </div> -->
	</div>
	<!-- Display Popup Button -->
	<div id="abc">
		<!-- Popup Div Starts Here -->
		<div id="popupContact">
			<!-- Contact Us Form -->
			<!-- id="form"  name="form" -->

			<%
				Logger logger = Logger.getLogger(this.getClass().getName());
			%>

			<%-- <form method="POST" action="project" modelAttribute="projectcreate" commandName="projectcreate">  --%>
			<form action="#" id="form" method="post" name="form">
				<img id="close"
					src="<c:url value="/resources/images/close-button-icon.png" />"
					alt="" onclick="div_hide()" />
				<%-- <img src="<c:url value="/resources/images/left_arrow.png" />" alt="" /> --%>
				<%
					logger.info("Evaluating date ");
				%>
				<h2>Create a project</h2>
				<hr>
				<input id="name" name="name" placeholder="My awesome project"
					type="text">
				
				<a href="javascript:%20check_empty()" id="submit">Create Project</a>
				<!-- <href="javascript:%20div_hide()" input type="close"  value="Cancel" />  -->
			</form>
		</div>
		
	<script>
	name_show();
    </script>
</body>
</html>