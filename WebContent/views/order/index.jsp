<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<table class="table table-bordered">
		<tr>
			<th>Tel</th>
			<th>Email</th>
			<th>Date</th>
			<th>Address</th>
			<th>Total</th>
			<th>Detail</th>
		</tr>
	<c:forEach var="o" items="${list}">
		<tr>
			<td>${o.tel }</td>
			<td>${o.email}</td>
			<td><fmt:formatDate pattern="dd/MM/yyyy" value="${o.dated}"/></td>
			<td>${o.address}</td>
			<td><fmt:formatNumber value="${o.total}"/></td>
			<td>
				<a href="${pageContext.request.contextPath}/cart/detail.html/${o.id}">Detail</a>
		</tr>
	</c:forEach>
</table>