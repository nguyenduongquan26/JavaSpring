<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<input type="file" name="file">
	</p>
	<p>
	<button>Upload</button>
	</p>
</form>
<img  src="${pageContext.request.contextPath}/upload/${file}">
</body>
</html>