<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<link href='<spring:url value="/resources/css/styles.css"/>'
		rel="stylesheet" />
	<style type="text/css">
		.error {
			color: red;
		}
	</style>
</head>
<body>
	<form:form id="regForm" modelAttribute="user" action="registerProcess"
		method="post">
		<div class="outer-box">
			<div class="login-box">
				<h4 class="login-text">Account Information</h4>
				<center>
					<table align="center">
						<tr>
							<td><form:label path="username">Username</form:label></td>
							<td><form:input path="username" name="username"
									id="username" />
								<form:errors path="username" cssClass="error" />
							</td>
						</tr>
						<tr>
							<td><form:label path="email">Email</form:label></td>
							<td><form:input path="email" name="email" id="email" />
								<form:errors path="email" cssClass="error" />
							</td>
						</tr>
						<tr>
							<td><form:label path="password">Password</form:label></td>
							<td><form:password path="password" name="password"
									id="password" />
								<form:errors path="password" cssClass="error" />
							</td>
						</tr>
						<tr>
							<td><form:label path="confirmPassword">Confirm Password</form:label>
							</td>
							<td><form:password path="confirmPassword"
									name="confirmPassword" id="confirmPassword" />
								<form:errors path="confirmPassword" cssClass="error" />
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<button id="btn-login" type="submit">Save</button>
							</td>
						</tr>
					</table>
				</center>
			</div>
		</div>
	</form:form>
</body>
</html>
