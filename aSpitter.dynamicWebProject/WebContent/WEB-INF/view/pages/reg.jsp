<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${spitter.userName} ${spitter.fullName} </title>
</head>
<body>
	<h3>REGISTRATION</h3>

	<!-- on form load - spring will execute getters to populate fields -->
	<!-- on form submit - spring will use setters to change field's values -->
	<form:form action="saveSpitter" modelAttribute="spitter" method="POST">
		<table>

			<!-- need to associate this data with customer id, when we use this form 
	to update current customer -->
			<form:hidden path="id" />
			<form:errors path="*" cssClass="error" />
			<tbody>
				<tr>
					<td><label>UserName</label></td>
					<td><form:input path="userName" /></td>
					<td><form:errors path="userName" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label>FullName</label></td>
					<td><form:input path="fullName" /></td>
					<td><form:errors path="fullName" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label>Age</label></td>
					<td><form:input path="age" /></td>
					<form:errors path="age" cssClass="error" />
				<tr>
					<td><label>Password</label></td>
					<td><form:password path="password" /></td>
					<form:errors path="password" cssClass="error" />
				</tr>
				<tr>
					<td><label>Email</label></td>
					<td><form:input path="email" /></td>
					<form:errors path="email" cssClass="error" />
				</tr>
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save" /></td>
				</tr>
			</tbody>
		</table>
	</form:form>
</body>
</html>