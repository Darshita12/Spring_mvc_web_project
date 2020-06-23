<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="insertuser" method="post" modelAttribute="userBean">
		<table>
			<tr>
				<td>FIRSTNAME</td>
				<td><form:input  type ="text" path="firstName" /></td>
			</tr>
			<tr>
				<td>LASTNAME</td>
				<td><form:input type ="text" path="lastName" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit" /></td>
			</tr>
		</table>
		
	</form:form>
</body>
</html>