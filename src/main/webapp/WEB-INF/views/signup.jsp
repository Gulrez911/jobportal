<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
<link href="./resources/css/bootstrap.min.css" type="stylesheet">
<script type="text/javascript" src="./resources/script/jquery.min.js"></script>
<script type="text/javascript" src="./resources/script/bootstrap.min.js"></script>
</head>
<body>
		<div class="container">
				<form:form action="signupSuccess" method="post" modelAttribute="user">
Name:<form:input path="name" />
Email Id:<form:input path="email" />
Phone Number:<form:input path="phone" />
						<input type="submit" value="Sign Up">
				</form:form>
		</div>
</body>
</html>