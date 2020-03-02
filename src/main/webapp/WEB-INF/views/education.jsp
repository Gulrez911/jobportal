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
			<form:form action="saveEducation" method="post"
				modelAttribute="education">
				<tr>
					<td>Education Level:</td>
					<td><form:input path="educationLevel" /></td>
				</tr>
				<tr>
					<td>Board:</td>
					<td><form:input path="board" /></td>
				</tr>
				<tr>
					<td>Passing Year:</td>
					<td><form:input path="passingYear" /></td>
				</tr>
				<tr>
					<td>Medium:</td>
					<td><form:input path="medium" /></td>
				</tr>
				<tr>
					<td>Total Marks:</td>
					<td><form:input path="totalMarks" /></td>
				</tr>
				<tr>
					<td>Course:</td>
					<td><form:input path="course" /></td>
				</tr>
				<tr>
					<td>Specialization:</td>
					<td><form:input path="specialization" /></td>
				</tr>
				<tr>
					<td>University:</td>
					<td><form:input path="university"  /></td>
				</tr>
				<tr>
					<td>Course Type:</td>
					<td><form:input path="courseType" /></td>
				</tr>
				<%-- Language Name:<form:input path="personalDetails.languageName"/> --%>
				<tr>
					<td><input type="submit" value="Sign Up"></td>
				</tr>
			</form:form>
		</table>
	</div>
</body>
</html>