<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- add jstl tags library  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	LAST SPITTLES

	<!-- use var spitters to hold list of spitters from model to have access to names -->
	<c:set var="spitters" value="${spitters}" />
	
	<table class="spittleTable">
		<c:forEach var="spittle" items="${spittles}">
			<tr>
				<td>${spitters[spittle.id].userName}</td>
				<td>ID: ${spittle.id}</td>
			</tr>
			<tr>
				<td colspan="2">${spittle.text}</td>
			</tr>
			<tr>
				<td colspan="2">Date: ${spittle.when}</td>
			</tr>
			<tr>
			</tr>
		</c:forEach>
	</table>
</body>
</html>