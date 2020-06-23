<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="com.controller.UserBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="updateuser" method="post" modelAttribute="userBean1">
        <table>
	<%-- <c:forEach items="${users }" var="userBean1"> --%>
            <form:hidden path="id"/>
            <tr>
                <td>FirstName:</td>
                <td><form:input type="text" path="firstName" /></td>
            </tr>
            <tr>
                <td>LastName:</td>
                <td><form:input type="text" path="lastName" /></td>
            </tr>
           
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Submit"></td>
            </tr>
<%--                     </c:forEach>
 --%>            
        </table>
        </form:form></body>
</html>