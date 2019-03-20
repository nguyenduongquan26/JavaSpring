<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:insertAttribute name="title"/></title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/css.css">
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"/></script>
</head>
<body>
	<div class="nav">
		<div class="container">
			<div class="brand">
				<a href="${pageContext.request.contextPath}">MiniShop</a>
			</div>
			<div class="nav-right">
				<ul>
					<c:choose>
						<c:when test="${not empty pageContext.request.userPrincipal}">
						<li>Welcome <b>${pageContext.request.userPrincipal.name}</b></li>
						<li>
							<form class="form-hidden" method="post" action="${pageContext.request.contextPath}/auth/logoff.html">
								<input type="hidden" name="_csrf" value="${_csrf.token}">
								<button>Logout</button>
							</form>
						</li>
						<li><a href="${pageContext.request.contextPath}/cart.html">Cart</a></li>
						<li><a href="${pageContext.request.contextPath}/order.html">Order</a></li>
						</c:when>
						<c:otherwise>
						<li>
						<a href="${pageContext.request.contextPath}/auth/logon.html">Log in</a>
						</li>
						<li>
						<a href="${pageContext.request.contextPath}/auth/register.html">Register</a>
						</li>
						</c:otherwise>
					</c:choose>
					
				</ul>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<div class="page">
		<div class="container">
			<div class="col-3">
				<ul>
				<c:forEach var="c" items="${categories}">
					<c:if test="${c.parent == 0 }">
						<li>${c.name}</li>
						<ul>
						<c:forEach var="ch" items="${categories}">
							<c:if test="${ch.parent == c.id }">
								<li><a href="${pageContext.request.contextPath}/home/browser.html/${ch.id}">${ch.name}</a></li>
							</c:if>
						</c:forEach>
						</ul>
					</c:if>
				</c:forEach>
				
				</ul>
			</div>
			<div class="col-9">
				<tiles:insertAttribute name="content"/>
			</div>
			<div class="clear"></div>
		</div>
	</div>
</body>
</html>