<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>


<form class="form-search" action="${pageContext.request.contextPath}/home/search.html">
	<input type ="text" name="q" placeholder="Search">
	<button class="btn btn-primary">Search</button>

</form>

<ul class="pagination">
<c:forEach var="i" begin="1" end="${n}">
		<li class="page-item">
			<a class="page-link" href="${pageContext.request.contextPath}/${i}">${i}</a>
		</li>	
</c:forEach>
</ul>

<c:forEach var="o" items="${list}">
	<div class="col-4">
		<div class="item">
			<a href="${pageContext.request.contextPath}/home/detail.html/${o.id}">
			<img width="200" src="${pageContext.request.contextPath}/images/${o.imageURL}">
			</a>
			<div class="info">
				<h2>
					<a href= "${pageContext.request.contextPath}/home/detail.html/${o.id}">${o.title}</a>
				</h2>
			</div>
		</div>
	</div>
</c:forEach>
<h3>Wishlist</h3>
<c:forEach var="o" items="${wishlist}">
	<div class="col-4">
		<div class="item">
			<a href="${pageContext.request.contextPath}/home/detail.html/${o.id}">
			<img width="200" src="${pageContext.request.contextPath}/images/${o.imageUrl}">
			</a>
			<div class="info">
				<h2>
					<a href= "${pageContext.request.contextPath}/home/detail.html/${o.id}">${o.title}</a>
				</h2>
			</div>
		</div>
	</div>
</c:forEach>
