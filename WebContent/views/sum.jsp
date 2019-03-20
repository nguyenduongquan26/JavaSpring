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
	<label>Nhap so a</label>
	<input type="number" value=${param.a } name="a">
</p>
<p>
	<label>Nhap so b</label>
	<input type="number" value=${param.b } name="b">
</p>
<button>Calculate</button>
</form>
${rs}
</body>
</html>