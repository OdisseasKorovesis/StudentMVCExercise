<%-- 
    Document   : studentlist
    Created on : May 7, 2020, 1:37:49 PM
    Author     : Odisseas KD
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Students List</title>
    </head>'/edit-${student.id}-student'
    <body>
        <h1>Student's list</h1>
        
        <table>
		<tr>
			<td>ID</td><td>First Name</td><td>Last Name</td><td>Date of Birth</td><td>Tuition Fees</td><td></td>
		</tr>
		<c:forEach items="${students}" var="student">
			<tr>
			<td><a href="<c:url value='/edit-${student.id}-student' />">${student.id}</a></td>
			<td>${student.firstName}</td>
			<td>${student.lastName}</td>
			<td>${student.dateOfBirth}</td>
                        <td>${student.tuitionFees}</td>
			<td><a href="<c:url value='/delete-${student.id}-student' />">delete</a></td>
			</tr>
		</c:forEach>
	</table>
    </body>
</html>
