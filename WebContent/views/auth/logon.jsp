<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<form method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
<p>
	<label>User Name</label>
	<input type="text" name="username" placeholder="User Name">
</p>
<p>
	<label>Password</label>
	<input type="password" name="password" placeholder="Password">
</p>
<p>
	<button class="btn btn-primary">Log on</button>
</p>
</form>
