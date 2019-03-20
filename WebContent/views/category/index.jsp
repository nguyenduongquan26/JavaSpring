<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<a class="btn btn-info" href="${pageContext.request.contextPath }/category/add.html">Add</a>
<a class="btn btn-info" href="${pageContext.request.contextPath }/category/add2.html">Add2</a>
<table class="table table-bordered">
	<tr>
		<th>CategoryId</th>
		<th>CategoryName</th>
		<th>Edit</th>
		<th>Edit2</th>
	</tr>
	<c:forEach var="o" items="${list}">
		<c:if test="${o.parent == 0 }">
		<tr class="tit">
			<td>${o.id}</td>
			<td>${o.name}</td>
			<td>
				<a href="${pageContext.request.contextPath}/category/admin/edit.html/${o.id}">
					<img src="${pageContext.request.contextPath}/images/edit.png">
				</a>
			</td>
			<td>
				<a href="${pageContext.request.contextPath}/category/admin/edit2.html/${o.id}">
					<img src="${pageContext.request.contextPath}/images/edit.png">
				</a>
			</td>
		<c:forEach var="h" items="${list}">
			<c:if test="${h.parent == o.id }">
				<tr>
					<td>${h.id }</td>
					<td>${h.name}</td>
					<td>
						<a href="${pageContext.request.contextPath}/category/admin/edit.html/${h.id}">
						<img src="${pageContext.request.contextPath}/images/edit.png">
						 </a>
					</td>
					
					<td>
						<a href="${pageContext.request.contextPath}/category/admin/edit2.html/${h.id}">
						<img src="${pageContext.request.contextPath}/images/edit.png">
						 </a>
					</td>
				</tr>
			</c:if>
		</c:forEach>
		</c:if>
	</c:forEach>
</table>
<style>
.tit{
	background-color : orange;
	color: blue;
}
</style>
