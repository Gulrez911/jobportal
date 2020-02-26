<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
		<form:form action="saveDetails" method="post" modelAttribute="personalDetails">
Permanent Address:<form:input path="permanentAddress" />
Gender:<form:input path="gender" />
Marital Status:<form:input path="maritalStatus" />
Hometown:<form:input path="hometown" />
Category:<form:input path="category" />
Defferently Abled:<form:input path="defferentlyAbled" />
Dob:<form:input path="dob" />
Language Name:<form:input path="personalDetails.languageName"/>
			<input type="submit" value="Sign Up">
		</form:form>
	</div>
</body>
</html>