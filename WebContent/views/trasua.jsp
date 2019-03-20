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
	<table>
		<tr>
			<th>Thuc don</th>
			<th>Gia</th>
		</tr>
		<tr>
			<td><input type="checkbox" name="checkbox" value="20000"></td>
			<td>Tra sua</td>
			<td>20.000VND</td>
		</tr>
		<tr>
			<td><input type="checkbox" name="checkbox" value="15000"></td>
			<td>Pepsi</td>
			<td>15.000VND</td>
		</tr>
		<tr>
			<td><input type="checkbox" name="checkbox" value="10000"></td>
			<td>Nuoc suoi</td>
			<td>10.000VND</td>
		</tr>
		<tr>
			<td><input type="checkbox" name="checkbox" value="20000"></td>
			<td>Nuoc cam</td>
			<td>20.000VND</td>
		</tr>
		<tr>
			<td><input type="checkbox" name="checkbox" value="30000"></td>
			<td>Ruou</td>
			<td>30.000VND</td>
		</tr>
	</table>
	<p><button>Tinh tien</button></p>
</form>
<p>Tong: ${s }</p>
</body>
</html>