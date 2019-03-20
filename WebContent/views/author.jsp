<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post">
	<p>
		<label>AuthorId</label>
		<input type="number" name="id">
	</p>
	<p>
		<label>Author Name</label>
		<input type="text" name="name">
	</p>
	<button>Save</button>
</form>
${id}
${name}
</body>
</html>