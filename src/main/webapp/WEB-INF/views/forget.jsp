<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forget</title>
<link href="./resources/css/bootstrap.min.css" type="stylesheet">
<script type="text/javascript" src="./resources/script/jquery.min.js"></script>
<script type="text/javascript" src="./resources/script/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
				<form action="getOtp" method="post">
Enter Email: <input type="text" name="email" />
						<input type="submit" value="Share OTP">
				</form>

		</div>
</body>
</html>