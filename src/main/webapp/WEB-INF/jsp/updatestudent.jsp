<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Student Record</title>
</head>
<body>
	<h1>Edit Employee</h1>
	<form:form method="POST" action="/DemoApp/update">
		<table border="2" width="70%" cellpadding="2">
			<tr>
				<td></td>
				<td><form:hidden path="rollNumber" /></td>
			</tr>
			<tr>
				<td>First Name :</td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name :</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Update Student" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>