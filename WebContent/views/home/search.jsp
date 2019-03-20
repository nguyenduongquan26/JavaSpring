<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>



<form class="form-search" action="${pageContext.request.contextPath}/home/search.html">
	<input type ="text" name="q" value="${q}" >
	<button class="btn btn-primary">Search</button>

</form>

<div class="product">
	<c:forEach var="o" items="${list}">
		<div class="col-4">
			<div class="item">
				<a href="${pageContext.request.contextPath}/home/detail.html/${o.id}">
					<img  src="${pageContext.request.contextPath}/images/${o.imageURL}">
				</a>
				<div class="info">
					<h2>
						<a href="${pageContext.request.contextPath}/home/detail.html/${o.id}">${o.title}</a>
					</h2>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
