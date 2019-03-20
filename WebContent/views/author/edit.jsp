<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<form class="form" method="post">
	<input name="id" type="hidden" value="${o.id}">
	<p>
		<label>Name</label>
		<input type="text" name="name" value="${o.name}">
	</p>
	<p>
		<button class="btn btn-primary">Save</button>
	</p>
</form>
