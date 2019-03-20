<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="page-header">
<h2>${o.name}</h2>
</div>

<div class="product">
<c:forEach var="o" items="${list}">
	<div class="col-4">
		<div class="item">
			<img width="200" src="${pageContext.request.contextPath}/images/${o.imageURL}">
			<div class="info">
				<h2>
					<a href= "${pageContext.request.contextPath}/home/detail.html/${o.id}">${o.title}</a>
				</h2>
			</div>
		</div>
	</div>
</c:forEach>
</div> 