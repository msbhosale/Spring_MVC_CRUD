<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>
</head>
<body>

	<h1>Student List</h1>
	<a href="studentform">Add New Student</a>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Roll Number</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Edit</th>
		</tr>
		<c:forEach var="student" items="${studentsList}">
			<tr>
				<td>${ student.rollNumber }</td>
				<td>${ student.firstName }</td>
				<td>${ student.lastName }</td>
				<td><a href="./updatestudent/${student.rollNumber}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
</body>
</html>