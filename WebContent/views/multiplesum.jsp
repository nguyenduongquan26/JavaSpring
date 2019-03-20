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
<form method="post">
	<c:forEach var="i" begin="1" end="10" step="1" >
		<p>
			<label>Nhap so ${i}</label>
			<input type="number" name="num">
		</p> 
	</c:forEach>
	<button>Calculate</button>
</form>
${s}
</body>
</html>