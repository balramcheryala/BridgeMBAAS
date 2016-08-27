<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BridgeMbaas</title>
<style type="text/css">
@import url(https://fonts.googleapis.com/css?family=Montserrat);

body {
	display: -webkit-box;
	display: -webkit-flex;
	display: -ms-flexbox;
	display: flex;
	-webkit-box-orient: vertical;
	-webkit-box-direction: normal;
	-webkit-flex-direction: column;
	-ms-flex-direction: column;
	flex-direction: column;
	-webkit-box-align: center;
	-webkit-align-items: center;
	-ms-flex-align: center;
	align-items: center;
	-webkit-box-pack: center;
	-webkit-justify-content: center;
	-ms-flex-pack: center;
	justify-content: center;
	height: 100vh;
	font-family: Montserrat;
	background: #313E50;
}

.text-input {
	position: relative;
	margin-top: 50px;
}

.text-input input[type="text"] {
	display: inline-block;
	width: 500px;
	height: 40px;
	box-sizing: border-box;
	outline: none;
	border: 1px solid lightgray;
	border-radius: 3px;
	padding: 10px 10px 10px 100px;
	-webkit-transition: all 0.1s ease-out;
	transition: all 0.1s ease-out;
}

.text-input input[type="text"]+label {
	position: absolute;
	top: 0;
	left: 0;
	bottom: 0;
	height: 40px;
	line-height: 40px;
	color: white;
	border-radius: 3px 0 0 3px;
	padding: 0 20px;
	background: #E03616;
	-webkit-transform: translateZ(0) translateX(0);
	transform: translateZ(0) translateX(0);
	-webkit-transition: all 0.3s ease-in;
	transition: all 0.3s ease-in;
	-webkit-transition-delay: 0.2s;
	transition-delay: 0.2s;
}

.text-input input[type="text"]:focus+label {
	-webkit-transform: translateY(-120%) translateX(0%);
	transform: translateY(-120%) translateX(0%);
	border-radius: 3px;
	-webkit-transition: all 0.1s ease-out;
	transition: all 0.1s ease-out;
}

.text-input input[type="text"]:focus {
	padding: 10px;
	-webkit-transition: all 0.3s ease-out;
	transition: all 0.3s ease-out;
	-webkit-transition-delay: 0.2s;
	transition-delay: 0.2s;
}
</style>
<!-- Theme initialization -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/normalize.css" />" />
</head>

<body>
	<form action="/bridgembaas/post">
		<div class="text-input">
			<input type="text" name="tweet" value=""
				placeholder="         Tweet something in here!"> <label
				for="input1">Tweet Here</label> <input type="submit" value="Post">
		</div>
	</form>
</body>
</html>