<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- add jstl tags library  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/tableSpitter.css">
<title>${spitter.userName}${spitter.fullName}</title>
</head>
<body>

	<div class="spitter">
		<table class="spittersTable">
			<tr>
				<th>ID</th>
				<th>User</th>
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
			<tr>
				<c:url var="updatelink" value="/showFormForUpdate">
					<c:param name="spitterId" value="${spitter.id}" />
				</c:url>
				<c:url var="deletelink" value="/delete">
					<c:param name="spitterId" value="${spitter.id}" />
				</c:url>
				<%-- <td>Spitter ID: <c:out value="${spitter.id}"/></td> --%>
				<td>${spitter.id}</td>
				<!-- will call spitters.getUserName() -->
				<td>${spitter.userName}</td>
				<!-- will call spitters.getFullName() -->
				<td>${spitter.fullName}</td>
				<!-- will call spitter.getAge() -->
				<td>${spitter.age}</td>
				<!-- will call spitters.getPassword() -->
				<td>${spitter.password}</td>
				<!-- will call spitters.getEmail() -->
				<td>${spitter.email}</td>
				<!-- will call spitters.getUpdateByEmail() -->
				<td>${spitter.updateByEmail}</td>
				<!-- will call spitters.getTimestamp() -->
				<td>${spitter.date}</td>
				<!-- will call spitters.getTimestamp() -->
				<td>${spitter.time}</td>
				<!-- will call spitters.getTimestamp() -->
				<td>${spitter.timestamp}</td>

				<!-- display the update and delete link -->
				<!-- will call updateLink variable from this page -->
				<td><a href="${updateLink}">UPDATE</a></td>
				<!-- will call deleteLink variable from this page -->
				<td><a href="${deleteLink}"
					onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">DELETE</a></td>
			</tr>
		</table>
		</div>

		<!-- 	Spittlesssss -->
		<table class="spittersTable">
			<tr>
				<th>ID</th>
				<th>Spittle</th>
				<th>Time</th>
			</tr>
			table here
			<c:forEach var="spittle" items="${spittles}">
				<tr>
					<td>${spittle.id}</td>
					<%-- 				<td>${spittle.spitter.id}</td> --%>
					<td>${spittle.text}</td>
					<td>${spittle.when}</td>
				</tr>
			</c:forEach>
		</table>
	

</body>
</html>