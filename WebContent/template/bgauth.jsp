<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:insertAttribute name="title"/></title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/css.css">
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"/></script>
</head>
<body>
	<div class="panel-login">
		<div class="panel-heading">
			<div class="panel-title"><tiles:insertAttribute name="title"/></div>
		</div>
		<div class="panel-body">
			<tiles:insertAttribute name="content"/>
		</div>
	</div>
</body>
</html>