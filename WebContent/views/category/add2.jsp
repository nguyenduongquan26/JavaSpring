<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form method="post" cssClass="form" modelAttribute="category">
<input type="hidden" name="_csrf" value="${_csrf.token }">
	<p>
		<label>Name</label>
		<form:input path="name"/>
	</p>
	<p>
		<label>Parent</label>
		<form:select path="parent">
			<form:option value="Select parent"/>
			<form:options itemLabel="name"  itemValue="id" items="${list}"/>
		</form:select>
	</p>
	<p>
		<button class="btn btn-primary">Save</button>
	</p>
</form:form>