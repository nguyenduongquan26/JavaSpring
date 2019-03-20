<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form method="post">
<input type="hidden" name="_csrf" value="${_csrf.token }">
<input name="id" type="hidden" value="${o.id}">
	<p>
		<label>Name</label>
		<input type="text" name="name" value="${o.name}">
	</p>
	<p>
		<label>Parent</label>
		<select name="parent">
			<option value="">Select Parent</option>
			<c:forEach var="p" items="${parents}">
				<c:choose>
					<c:when test="${p.id == o.parent}">
						<option selected="selected" value="${p.id }">${p.name}</option>
					</c:when>
					<c:otherwise>
						<option value="${p.id}">${p.name}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
	</p>
	<p>
		<button>Save</button>
	</p>
</form>