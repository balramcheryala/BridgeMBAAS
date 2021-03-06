<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>${title}</title>

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
												style="background-image: url('assets/faces/3.jpg')"></div>
										</div>
										<div class="body-col">
											<p>
												<span class="accent">Zack Alien</span> pushed new commit: <span
													class="accent">Fix page load performance issue</span>.
											</p>
										</div>
								</a></li>
								<li><a href="" class="notification-item">
										<div class="img-col">
											<div class="img"
												style="background-image: url('assets/faces/5.jpg')"></div>
										</div>
										<div class="body-col">
											<p>
												<span class="accent">Amaya Hatsumi</span> started new task:
												<span class="accent">Dashboard UI design.</span>.
											</p>
										</div>
								</a></li>
								<li><a href="" class="notification-item">
										<div class="img-col">
											<div class="img"
												style="background-image: url('assets/faces/8.jpg')"></div>
										</div>
										<div class="body-col">
											<p>
												<span class="accent">Andy Nouman</span> deployed new version
												of <span class="accent">NodeJS REST Api V3</span>
											</p>
										</div>
								</a></li>
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
							</div> <span class="name"> ${user} </span>
					</a>
						<div class="dropdown-menu profile-dropdown-menu"
							aria-labelledby="dropdownMenu1">
							<a class="dropdown-item" href="#"> <i class="fa fa-user icon"></i>
								Profile
							</a> <a class="dropdown-item" href="#"> <i
								class="fa fa-bell icon"></i> Notifications
							</a> <a class="dropdown-item" href="#"> <i
								class="fa fa-gear icon"></i> Settings
							</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="logout"> <i
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
				<nav class="menu">
				<ul class="nav metismenu" id="sidebar-menu">
					<li><a href="dashboard"> <i class="fa fa-home"></i>
							Dashboard
					</a></li>
					<li class="active open"><a href=""> <i
							class="fa fa-th-large"></i> Auth <i class="fa arrow"></i>
					</a>
						<ul>
							<li><a href="userpage"> Users </a></li>
							<li class="active"><a href="signinby"> Sign-in Method </a></li>
						</ul></li>
			</aside>
			<div class="sidebar-overlay" id="sidebar-overlay"></div>
			<article class="content item-editor-page">
			<div class="title-block">
				<h3 class="title">
					Sign-in providers<span class="sparkline bar" data-type="bar"></span>
				</h3>
			</div>
			<form name="item">
				<div class="card items">
					<ul class="item-list striped">
						<li class="item item-list-header hidden-sm-down">
							<div class="item-row">
								<div class="item-col fixed item-col-check"></div>
								<div class="item-col item-col-header fixed item-col-img md">
									<div>
										<span>Provider</span>
									</div>
								</div>
								<div class="item-col item-col-header item-col-title">
									<div>
										<span></span>
									</div>
								</div>
								<div class="item-col item-col-header item-col-sales">
									<div>
										<span></span>
									</div>
								</div>
								<div class="item-col item-col-header item-col-stats">
									<div class="no-overflow">
										<span></span>
									</div>
								</div>
								<div class="item-col item-col-header item-col-category">
									<div class="no-overflow">
										<span></span>
									</div>
								</div>

								<div
									class="item-col item-col-header fixed item-col-actions-dropdown">
								</div>
							</div>
						</li>
						<li class="item">
							<div class="item-row">
								<div class="item-col fixed item-col-check"></div>
								<div class="item-col fixed item-col-img md">
									<a href="signinby">
										<div class="item-img rounded"
											style="background-image: url(http://www.tutorialspoint.com/images/googlePlusIcon.jpg"></div>
									</a>
								</div>
								<div class="item-col fixed pull-left item-col-title">
									<div class="item-heading">Name</div>
									<div>
										<a href="signinby" class="">
											<h4 class="item-title"></h4>
										</a>
									</div>
								</div>
								<div class="item-col item-col-sales"></div>

								<div class="item-col item-col-author">
									<div class="item-heading">Status</div>
									<div class="no-overflow">
										<a href="id_secure">Google Enable/Disable</a>
									</div>
								</div>

								<div class="item-col fixed item-col-actions-dropdown">
									<div class="item-actions-dropdown">
										<a class="item-actions-toggle-btn"> <span class="inactive">
												<i class="fa fa-cog"></i>
										</span> <span class="active"> <i
												class="fa fa-chevron-circle-right"></i>
										</span>
										</a>
										<div class="item-actions-block">
											<ul class="item-actions-list">
												<li><a class="remove" href="#" data-toggle="modal"
													data-target="#confirm-modal"> <i class="fa fa-trash-o "></i>
												</a></li>
												<li><a class="edit" href="#"> <i
														class="fa fa-pencil"></i>
												</a></li>
											</ul>
										</div>
									</div>
								</div>
							</div>
						</li>


						<li class="item">
							<div class="item-row">
								<div class="item-col fixed item-col-check"></div>
								<div class="item-col fixed item-col-img md">
									<a href="signinby">
										<div class="item-img rounded"
											style="background-image: url(http://www.tutorialspoint.com/images/twitterIcon.jpg"></div>
									</a>
								</div>
								<div class="item-col fixed pull-left item-col-title">
									<div class="item-heading">Name</div>
									<div>
										<a href="signinby" class="">
											<h4 class="item-title"></h4>
										</a>
									</div>
								</div>
								<div class="item-col item-col-sales"></div>

								<div class="item-col item-col-author">
									<div class="item-heading">Status</div>
									<div class="no-overflow">
										<a href="id_secure">Twitter Enable/Disable</a>
									</div>
								</div>

								<div class="item-col fixed item-col-actions-dropdown">
									<div class="item-actions-dropdown">
										<a class="item-actions-toggle-btn"> <span class="inactive">
												<i class="fa fa-cog"></i>
										</span> <span class="active"> <i
												class="fa fa-chevron-circle-right"></i>
										</span>
										</a>
										<div class="item-actions-block">
											<ul class="item-actions-list">
												<li><a class="remove" href="#" data-toggle="modal"
													data-target="#confirm-modal"> <i class="fa fa-trash-o "></i>
												</a></li>
												<li><a class="edit" href="#"> <i
														class="fa fa-pencil"></i>
												</a></li>
											</ul>
										</div>
									</div>
								</div>
							</div>
						</li>

						<li class="item">
							<div class="item-row">
								<div class="item-col fixed item-col-check"></div>
								<div class="item-col fixed item-col-img md">
									<a href="signinby">
										<div class="item-img rounded"
											style="background-image: url(http://www.tutorialspoint.com/images/facebookIcon.jpg"></div>
									</a>
								</div>
								<div class="item-col fixed pull-left item-col-title">
									<div class="item-heading">Name</div>
									<div>
										<a href="signinby" class="">
											<h4 class="item-title"></h4>
										</a>
									</div>
								</div>
								<div class="item-col item-col-sales"></div>

								<div class="item-col item-col-author">
									<div class="item-heading">Status</div>
									<div class="no-overflow">
										<a href="id_secure">FaceBook Enable/Disable</a>
									</div>
								</div>

								<div class="item-col fixed item-col-actions-dropdown">
									<div class="item-actions-dropdown">
										<a class="item-actions-toggle-btn"> <span class="inactive">
												<i class="fa fa-cog"></i>
										</span> <span class="active"> <i
												class="fa fa-chevron-circle-right"></i>
										</span>
										</a>
										<div class="item-actions-block">
											<ul class="item-actions-list">
												<li><a class="remove" href="#" data-toggle="modal"
													data-target="#confirm-modal"> <i class="fa fa-trash-o "></i>
												</a></li>
												<li><a class="edit" href="#"> <i
														class="fa fa-pencil"></i>
												</a></li>
											</ul>
										</div>
									</div>
								</div>
							</div>
						</li>

						<li class="item">
							<div class="item-row">
								<div class="item-col fixed item-col-check"></div>
								<div class="item-col fixed item-col-img md">
									<a href="signinby">
										<div class="item-img rounded"
											style="background-image: url(http://www.tutorialspoint.com/images/linkedinIcon.jpg"></div>
									</a>
								</div>
								<div class="item-col fixed pull-left item-col-title">
									<div class="item-heading">Name</div>
									<div>
										<a href="signinby" class="">
											<h4 class="item-title"></h4>
										</a>
									</div>
								</div>
								<div class="item-col item-col-sales"></div>

								<div class="item-col item-col-author">
									<div class="item-heading">Status</div>
									<div class="no-overflow">
										<a href="id_secure">LinkedInEnable/Disable</a>
									</div>
								</div>

								<div class="item-col fixed item-col-actions-dropdown">
									<div class="item-actions-dropdown">
										<a class="item-actions-toggle-btn"> <span class="inactive">
												<i class="fa fa-cog"></i>
										</span> <span class="active"> <i
												class="fa fa-chevron-circle-right"></i>
										</span>
										</a>
										<div class="item-actions-block">
											<ul class="item-actions-list">
												<li><a class="remove" href="#" data-toggle="modal"
													data-target="#confirm-modal"> <i class="fa fa-trash-o "></i>
												</a></li>
												<li><a class="edit" href="#"> <i
														class="fa fa-pencil"></i>
												</a></li>
											</ul>
										</div>
									</div>
								</div>
							</div>
						</li>
						<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
		<div class="modal fade" id="confirm-modal">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">
							<i class="fa fa-warning"></i> Alert
						</h4>
					</div>
					<div class="modal-body">
						<p>Are you sure want to do this?</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal">Yes</button>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">No</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
	</div>
	<!-- Reference block for JS -->
	<div class="ref" id="ref">
		<div class="color-primary"></div>
		<div class="chart">
			<div class="color-primary"></div>
			<div class="color-secondary"></div>
		</div>
	</div>
	<script type="text/javascript"
		src="<c:url value="/resources/js/vendor.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/app.js" />"></script>
	</div>
</body>

</html>
