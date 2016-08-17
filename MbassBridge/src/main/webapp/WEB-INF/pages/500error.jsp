<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	isErrorPage="true" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="https://storage.googleapis.com/code.getmdl.io/1.0.0/material.indigo-pink.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="apple-touch-icon" href="apple-touch-icon.png">
<!-- Place favicon.ico in the root directory -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/vendor.css" />" />
<!-- Theme initialization -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/app-orange.css" />" />
</head>

<body>
	<div class="main-wrapper">
		<div class="app" id="app">
			<header class="header">
				<div class="header-block header-block-collapse hidden-lg-up">
					<button class="collapse-btn" id="sidebar-collapse-btn">
						<i class="fa fa-bars"></i>
					</button>
				</div>
				<div class="header-block header-block-search hidden-sm-down">
					<form role="search">
						<div class="input-container">
							<i class="fa fa-search"></i> <input type="search"
								placeholder="Search">
							<div class="underline"></div>
						</div>
					</form>
				</div>
				<div class="header-block header-block-buttons"></div>
				<div class="header-block header-block-nav">
					<ul class="nav-profile">
						<li class="notifications new"><a href=""
							data-toggle="dropdown"> <i class="fa fa-bell-o"></i> <sup>
									<span class="counter">8</span>
							</sup>
						</a>
							<div class="dropdown-menu notifications-dropdown-menu">
								<ul class="notifications-container">
									<li><a href="" class="notification-item">
											<div class="img-col">
												<div class="img"
													style="background-image: url('http://tinyurl.com/h9uonzq')"></div>
											</div>
											<div class="body-col">
												<p>
													<span class="accent">BridgeLabz</span> pushed new commit: <span
														class="accent">Fix page load performance issue</span>.
												</p>
											</div>
									</a></li>
									<li><a href="" class="notification-item">
											<div class="img-col">
												<div class="img"
													style="background-image: url('assets/faces/5.jpg')"></div>
											</div>
											<div class="body-col"></div>
									</a></li>
									<li>
								</ul>
								<footer>
									<ul>
										<li><a href=""> View All </a></li>
									</ul>
								</footer>
							</div></li>
						<li class="profile dropdown"><a
							class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
							role="button" aria-haspopup="true" aria-expanded="false">
								<div class="img"
									style="background-image: url('http://tinyurl.com/h9uonzq')">
								</div> <span class="name"> ${user}</span>
						</a>
							<div class="dropdown-menu profile-dropdown-menu"
								aria-labelledby="dropdownMenu1">
								<a class="dropdown-item" href="#"> <i
									class="fa fa-user icon"></i> Profile
								</a> <a class="dropdown-item" href="#"> <i
									class="fa fa-bell icon"></i> Notifications
								</a> <a class="dropdown-item" href="#"> <i
									class="fa fa-gear icon"></i> Settings
								</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="login.html"> <i
									class="fa fa-power-off icon"></i> Logout
								</a>
							</div></li>
					</ul>
				</div>
			</header>
			<aside class="sidebar">
				<div class="sidebar-container">
					<div class="sidebar-header">
						<div class="brand">
							<div class="logo">
								<span class="l l1"></span> <span class="l l2"></span> <span
									class="l l3"></span> <span class="l l4"></span> <span
									class="l l5"></span>
							</div>
							${title}
						</div>
					</div>
				</div>


			</aside>
			<div class="sidebar-overlay" id="sidebar-overlay"></div>
			<article class="content error-404-page">
				<section class="section">
					<div class="error-card">
						<div class="error-title-block">
							<h1 class="error-title">500</h1>
							<h2 class="error-sub-title">Sorry, page not found</h2>
						</div>
						<div class="error-container">
							<p>You better try our awesome search:</p>
							<div class="row">
								<div class="col-xs-12">
									<div class="input-group">
										<input type="text" class="form-control"> <span
											class="input-group-btn">
											<button class="btn btn-primary" type="button">Search</button>
										</span>
									</div>
								</div>
							</div>
							<br> <a class="btn btn-primary" href="userpage"><i
								class="fa fa-angle-left"></i> Back to Dashboard</a>
						</div>
					</div>
				</section>
			</article>

			<!-- Reference block for JS -->
			<div class="ref" id="ref">
				<div class="color-primary"></div>
				<div class="chart">
					<div class="color-primary"></div>
					<div class="color-secondary"></div>
				</div>
				<script type="text/javascript"
					src="<c:url value="/resources/js/vendor.js" />"></script>
				<script type="text/javascript"
					src="<c:url value="/resources/js/app.js" />"></script>
			</div>
</body>

</html>