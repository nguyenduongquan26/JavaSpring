<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" enctype="multipart/form-data">
	<p>
		<label>Choose file</label>
		<input type="file" name="file" multiple="multiple">
	</p>
	<p>
	<button>Upload</button>
	</p>
</form>
<c:forEach var = "list" items ="${file}">
<img width="200" src="${pageContext.request.contextPath }/upload/${list}">
</c:forEach>
</body>
</html>