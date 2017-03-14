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

<!-- 	<ol class="spittleTable"> -->
<%-- 		<c:forEach var="spittle" items="${spittles}"> --%>
<!-- 			<div class="aLeft"> -->
<%-- 			<li>ID: ${spittle.id}</li> --%>
<%-- 			<li>${spittle.text}</li> --%>
<%-- 			<li>Date: ${spittle.when}</li> --%>
<!-- 			</div> -->
<%-- 		</c:forEach> --%>
<!-- 	</ol> -->

	<table class="spittle">
		<c:forEach var="spittle" items="${spittles}">
			<tr>
				<td>ID: ${spittle.id}</td>
			</tr>
			<tr>
				<td>${spittle.text}</td>
			</tr>
			<tr>
				<td>Date: ${spittle.when}</td>
			</tr>
			<tr>
				<td></td>
			</tr>
		</c:forEach>
	</table>







</body>
</html>