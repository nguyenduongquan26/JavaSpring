<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:insertAttribute name="title"/></title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/css.css">
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/js.js"></script>
</head>
<body>
	<div class="title">
		<div class="container">
			<div class="brand">Mini Shop</div>
			<div class="clear"></div>
		</div>
	</div>
	<div class="sidebar">
		<ul>
			<li>
				<a href="${pageContext.request.contextPath}/author.html">Author</a>
			</li>
			<li>
				<a href="${pageContext.request.contextPath}/publisher.html">Publisher</a>
			</li>
			<li>
				<a href="${pageContext.request.contextPath}/category.html">Category</a>
			</li>
		</ul>
	</div>
	<div class="main">
		<tiles:insertAttribute name="content"/>
	</div>
</body>
</html>