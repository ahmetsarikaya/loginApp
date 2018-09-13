<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<link href='<spring:url value="/resources/css/styles.css"/>'
	rel="stylesheet" />
</head>
<body>
	
<div class="outer-box">
		<div class="login-box">
			<h4 class="login-text">Account Information</h4>
			<center>
				<input placeholder="Username" value="${user.username}"> 
				<input placeholder="Password" value="${user.password}"> 
				<input placeholder="Email" value="${user.email}">
				<input placeholder="Confirm Password"  value="${user.roles}">

				<a id="btn-register" href='<spring:url value="/logout" />'>Logout</a>
			</center>
		</div>
	</div>
</body>
</html>
