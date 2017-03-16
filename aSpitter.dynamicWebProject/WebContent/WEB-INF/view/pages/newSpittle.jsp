<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet type="text/css" href="${pageContent.request.contextPath}/resources/css/newSpittle.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/newSpittle.css">
<title>New Spittle</title>
</head>
<body>
	<h3>NEW SPITTLE</h3>
<%-- 	<c:set var="spitters" value="${spitters}" /> --%>

	<!-- on form load - spring will execute getters to populate fields -->
	<!-- on form submit - spring will use setters to change field's values -->
	
	<form action="saveSpittle" method="POST">
	<table>
	<tr><td><input type="text" name="id"></td></tr>
	<tr><td><input type="text" name="text" id="text"></td></tr>
	<tr><td><input type="text" name="data"></td></tr>
	<tr><td><input type="submit" value="Save"></td></tr>
	
	</table>
	</form>
	
	
	
	
	
<%-- 	<form:form  method="POST"> --%>
<!-- 		<table> -->
<!-- 			<tbody> -->
<!-- 				<tr> -->
<!-- 					<td><label>UserId</label></td> -->
<%-- 					<td><form:input path="id"/></td> --%>
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td><label>Spittle</label></td> -->
<%-- 					<td><form:textarea  path="text" /></td> --%>
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td><label>Date</label></td> -->
<%-- 					<td><form:input path="data" /></td> --%>
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td><input type="submit" value="Save" /></td> -->
<!-- 				</tr> -->
<!-- 			</tbody> -->
<!-- 		</table> -->
<%-- 	</form:form> --%>
</body>
</html>