<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- add jstl tags library  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources//css/tableSpitter.css">
<title>List of Spitters</title>
</head>
<body>

	<p6>LIST HERE</p6>
	<hr>
	<table class="spittersTable">
		<tr>
			<th>ID
				<div class="arrow">
					<a href="spittersByIdDesc" class="down-arrow"></a> <a
						href="spittersByIdAsc" class="up-arrow"></a>
				</div>
			</th>
			<th>UserName
				<div class="arrow">
					<a href="spittersByUserDesc" class="down-arrow"></a> <a
						href="spittersByUserAsc" class="up-arrow"></a>
				</div>
			</th>
			<th>FullName
				<div class="arrow">
					<a href="spittersByFullnameDesc" class="down-arrow"></a> <a
						href="spittersByFullnameAsc" class="up-arrow"></a>
				</div>
			</th>
			<th>Age
				<div class="arrow">
					<a href="spittersByAgeDesc" class="down-arrow"></a> <a
						href="spittersByAgeAsc" class="up-arrow"></a>
				</div>
			</th>
			<th>Creation/Update</th>
			<th>UPDATE</th>
			<th>DELETE</th>
			<th>INFO</th>
		</tr>

		<!-- foreach iterator which will iterate through list "spitters" 
		sended by adding attribute to model 
		items="${spitters} <- customers name from MVC theModel-->
		<c:forEach var="spitter" items="${spitters}">
			<tr>

				<!-- construct an "udpate" link with customer id --->
				<!--var - variable name to use somewhere,--->
				<!--value - urlpath which will be given,--->
				<!--c:param name - name of parameter added to model,--->
				<!--value - value of parameter added to model, in our case - spitter's id--->
				<c:url var="updateLink" value="/showFormForUpdate">
					<c:param name="spitterId" value="${spitter.id}" />
				</c:url>

				<c:url var="deleteLink" value="/delete">
					<c:param name="spitterId" value="${spitter.id}" />
				</c:url>

				<c:url var="fullInfo" value="/info">
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
				<!-- will call spitters.getTimestamp() -->
				<!-- 				&nbsp = space -->
				<td>${spitter.date}</td>

				<!-- display the update and delete link -->
				<!-- will call updateLink variable from this page -->
				<td><a href="${updateLink}">UPDATE</a></td>
				<!-- will call deleteLink variable from this page -->
				<td><a href="${deleteLink}"
					onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">DELETE</a></td>
				<!-- will call fullInfo variable from this page -->
				<td><a href="${fullInfo}">INFO</a></td>
			</tr>
		</c:forEach>
	</table>
	<iframe
		src="//coub.com/embed/shkq1?muted=false&autostart=false&originalSize=false&startWithHD=false"
		allowfullscreen="true" frameborder="0" width="530" height="452"></iframe>
	<img
		src="${pageContext.request.contextPath}/resources/images/how spring mvc.jpg">


</body>
</html>