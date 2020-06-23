<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="insertuser1" method="post" modelAttribute="userBean">

FirstNAme :- <form:input type="text" path="firstName" />
		<br>
LastName :- <form:input type="text" path="lastName" />
		<br>
		<input type="submit" value="submit">
	</form:form>


</body>
</html>