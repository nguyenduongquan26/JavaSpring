<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="table table-bordered">
	<tr>
		<th>Phone number</th>
		<th>Email</th>
		<th>Address</th>
	</tr>
	<tr>
		<td>${o.tel}</td>
		<td>${o.email}</td>
		<td>${o.address}</td>	
	</tr>

</table>
<table class="table table-bordered">
	<tr>
		<th>Title</th>
		<th>Price</th>
		<th>Quantity</th>
		<th>Total</th>
	</tr>
		<c:forEach var="dt" items="${o.details}">
		<tr>
			<td>${dt.title }</td>
			<td>${dt.price }</td>
			<td>${dt.quantity }</td>
			<td>${dt.price * dt.quantity }</td>
		</tr>
	</c:forEach>
</table>