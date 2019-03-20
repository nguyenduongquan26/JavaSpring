<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form method="post" class="form">
	<input type="hidden" name="_csrf" value="${_csrf.token }">
	<p>
		<label>Name</label>
		<input type="text" name="name">
	</p>
	<p>
		<label>Parent</label>
		<select name="parent">
			<option value="">Select Parent</option>
			<c:forEach var="o" items="${list}">
				<option value="${o.id}">${o.name}</option>
			</c:forEach>
		</select>
	</p>
	<p>
		<button class="btn btn-primary">Save</button>
</form>