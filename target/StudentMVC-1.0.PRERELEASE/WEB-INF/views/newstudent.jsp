<%-- 
    Document   : newstudent
    Created on : May 7, 2020, 4:46:36 PM
    Author     : Odisseas KD
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Student</title>
    </head>
    <body>
        <h1>Register a new student</h1>
        <form:form method="POST" modelAttribute="student">
            <form:input type="hidden" path="id" id="id"/>
            First Name: <form:input path="firstName" id="firstName"/>
            <br>
            Last Name: <form:input path="lastName" id="lastName"/>
            <br>
            Date of Birth <form:input path="dateOfBirth" id="dateOfBirth" />
            <br>
            Tuition Fees <form:input path="tuitionFees" id="tuitionFees"/>
            <br>


            <c:choose>
                <c:when test="${edit}">
                    <input type="submit" value="Update"/>
                </c:when>
                <c:otherwise>
                    <input type="submit" value="Register"/>
                </c:otherwise>
            </c:choose>


        </form:form>            

        ${message}

        <br/>
        <br/>
        Go back to <a href="<c:url value='/list' />">List of All Employees</a>

    </body>
</html>
