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

	<p6>LIST HERE</p6>
	<hr>
	<table>
		<tr>
			<th>UserName</th>
			<th>FullName</th>
			<th>Email</th>
			<th>Password</th>
			<th>Creation/Update time</th>
		</tr>
		<td><a>dfsdf</a></td>

		<!-- foreach iterator which will iterato throug list "spitters" 
		sended by adding attribute to model 
		items="${spitters} <- customers name from MVC theModel-->
		<c:forEach var="spitter" items="${spitters}">
			<tr>
				<%-- <td>Employee ID: <c:out value="${spitter.id}"/></td> --%>
				<td>${spitter.id}</td>
				<!-- will call spitters.getUserName() -->
				<td>${spitter.userName}</td>
				<!-- will call spitters.getFullName() -->
				<td>${spitter.fullName}</td>
				<!-- will call spitters.getEmail() -->
				<td>${spitter.email}</td>
				<!-- will call spitters.getUpdateByEmail() -->
				<td>${spitter.updateByEmail}</td>
				<!-- will call spitters.getTimestamp() -->
				<td>${spitter.timestamp}</td>
			</tr>
		</c:forEach>
	</table>



</body>
</html>