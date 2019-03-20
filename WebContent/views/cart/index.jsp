<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<tr data-id="${c.productId}">
		<td>${c.title}</td>
		<td><fmt:formatNumber type="currency" value="${c.price}"/></td>
		<td><input type="number" class="quantity" min="1" value="${c.quantity}"></td>
		<td><fmt:formatNumber type="currency" value="${c.price * c.quantity }" />
	</tr>

</c:forEach>
	<tr>
		<th colspan="3">Total</th>
		<td><fmt:formatNumber type="currency" value="${total }"/>
	</tr>
</table>
<form  action="${pageContext.request.contextPath}/cart/checkout.html">
		<p>
			<button class="btn btn-primary">Checkout</button>
		</p>
</form>
<script type="text/javascript">
$('.quantity').change(function(){
	var o = {'quantity':$(this).val(), 'productId':$(this).parent().parent().attr('data-id')};
	$.post('${pageContext.request.contextPath}/cart/edit.html',o,function(d){
		if(d==0){
			alert("Error");
		}
	});
});
</script>