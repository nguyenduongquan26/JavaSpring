<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
	<div class="col-5">
		<img width="200" src="${pageContext.request.contextPath}/images/${o.imageURL}">
	</div>
	<div class="col-7">
		<h1>${o.title}</h1>
		<p>${o.price}</p>
		<p>${o.description}</p>
		<form method="post" action="${pageContext.request.contextPath}/cart/add.html">
			<input type="hidden" name="productId" value="${o.id}">
			<label>Quantity :<input type="number" name="quantity" value="1" min="1"></label>
			<button class="btn btn-primary">Add to cart</button>
		</form>
	</div>
	<div class="clear"></div>
</div>

<div class="product">
	<h2>Related Product</h2>
	<c:forEach var="o" items="${list}">
	<div class="col-4">
		<div>
			<img width="150" src="${pageContext.request.contextPath}/images/${o.imageURL}">
			<div class="info">
				<h2>
					<a href= "${pageContext.request.contextPath}/home/detail.html/${o.id}">${o.title}</a>
				</h2>
			</div>
		</div>
	</div>
</c:forEach>
</div>