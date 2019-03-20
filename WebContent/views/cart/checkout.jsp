<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<table class="table table-bordered">
	<tr>
		<th>Title</th>
		<th>Price</th>
		<th>Quantity</th>
		<th>Amount</th>
	</tr>
	<c:set var="total" value="0"/>
<c:forEach var="c" items="${list}">
<c:set var="total" value="${total + c.price * c.quantity}" />
	<tr>
		<td>${c.title}</td>
		<td><fmt:formatNumber type="number" value="${c.price}"/></td>
		<td>${c.quantity}</td>
		<td><fmt:formatNumber type="number" value="${c.price * c.quantity }" />
	</tr>

</c:forEach>
	<tr>
		<th colspan="3">Total</th>
		<td><fmt:formatNumber type="number" value="${total }"/>
	</tr>
</table>
<form method="post">
	<p>
		<label>Email</label>
		<input type="email" name="email">
	</p>
	<p>
		<label>Address</label>
		<input type="text" name="address" >
	</p>
	<p>
		<label>Phone number</label>
		<input type="tel" name="tel" >
	</p>
	<button class="btn btn-primary">Confirm</button>
</form>