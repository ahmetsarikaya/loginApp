<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
	<link href='<spring:url value="/resources/css/styles.css"/>' rel="stylesheet" />
</head>
<body>
	
	<form action='<spring:url value="/loginAction" />' method="post">
	<div class="outer-box">
		<div class="login-box">
			<h4 class="login-text">Ebebek Log-in</h4>
			<center>
				<input placeholder="Username" name="username"> 
				<input type="password" placeholder="Password" name="password">

				<button id="btn-login" type="submit">Login</button>
				<a id="btn-register" href='<spring:url value="/register"/>'>Register</a>
			</center>
		</div>
	</div>
	</form>
</body>
</html>
