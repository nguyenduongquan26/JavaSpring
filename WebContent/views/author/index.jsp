<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<p>
<a class="btn btn-info" href="${pageContext.request.contextPath}/author/add.html">Add</a>
</p>
<form method="post" action="${pageContext.request.contextPath}/author/del.html">
<table class="table table-bordered">
	<tr>
		<th><button class="btn btn-primary">Delete</button></th>
		<th>ID</th>
		<th>Name</th>
		<th>Delete</th>
		<th>Edit</th>
	</tr>
	<c:forEach var="o" items="${list}">
		<tr>
			<td><input type ="checkbox" value="${o.id}" name="a" >
			<td>${o.id}</td>
			<td>${o.name}</td>
			<td>
			<a href = "${pageContext.request.contextPath}/author/del.html/${o.id}">
			<img src="${pageContext.request.contextPath}/images/trash.png" >
			</a>
			</td>
			<td>
			<a href = "${pageContext.request.contextPath}/author/edit.html/${o.id}">
			<img src="${pageContext.request.contextPath}/images/edit.png" >
			</a>
			</td>
		</tr>
	</c:forEach>
</table>
</form>
