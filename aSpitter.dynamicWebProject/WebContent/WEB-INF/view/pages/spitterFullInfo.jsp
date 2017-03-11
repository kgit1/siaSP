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

	<table>
		<tr>
			<th>ID</th>
			<th>UserName</th>
			<th>FullName</th>
			<th>Age</th>
			<th>Password</th>
			<th>Email</th>
			<th>EmailUpdate</th>
			<th>Creation/Update date</th>
			<th>Creation/Update time</th>
			<th>Creation/Update date+time</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<!-- foreach iterator which will iterate through list "spitters" 
		sended by adding attribute to model 
		items="${spitters} <- customers name from MVC theModel-->
		<%-- 		<c:forEach var="spitter" items="${spitters}"> --%>
		<tr>
			<c:url var="updatelink" value="/showFormForUpdate">
				<c:param name="spitterId" value="${spitter.id}" />
			</c:url>
			<c:url var="deletelink" value="/delete">
				<c:param name="spitterId" value="${spitter.id}" />
			</c:url>
			<td>${spitter.id}</td>
			<td>${spitter.userName}</td>
			<td>${spitter.fullName}</td>
			<td>${spitter.age}</td>
			<td>${spitter.password}</td>
			<td>${spitter.email}</td>
			<td>${spitter.updateByEmail}</td>
			<td>${spitter.date}</td>
			<td>${spitter.time}</td>
			<td>${spitter.timestamp}</td>
			<td><a href="${updateLink}">UPDATE</a></td>
			<td><a href="${deletelink}"
				onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">DELETE</a></td>
		</tr>

		<%-- 		</c:forEach> --%>
	</table>

</body>
</html>