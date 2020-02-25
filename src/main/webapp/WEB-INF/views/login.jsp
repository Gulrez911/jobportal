<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log In</title>
<link href="./resources/css/bootstrap.min.css" type="stylesheet">
<script type="text/javascript" src="./resources/script/jquery.min.js"></script>
<script type="text/javascript" src="./resources/script/bootstrap.min.js"></script>
</head>
<body>
		<div class="container">
				<form:form action="loginSuccess" method="post" modelAttribute="user">
Enter Email: <form:input path="email" />
Password : <form:password path="password" />
						<input type="submit" value="Log In">
				</form:form>

		</div>
</body>
</html>