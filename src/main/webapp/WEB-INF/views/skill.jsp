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
		<table>
			<form:form action="saveSkill" method="post" modelAttribute="skill">
				<tr>
					<td>Skill:</td>
					<td><form:input path="skill" /></td>
				</tr>
				<tr>
					<td>Version:</td>
					<td><form:input path="version" /></td>
				</tr>
				<tr>
					<td>Last Used:</td>
					<td><form:input path="lastUsed" /></td>
				</tr>
				<tr>
					<td>Experience:</td>
					<td><form:input path="experience" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Save Skill"></td>
				</tr>
			</form:form>
		</table>
	</div>
</body>
</html>