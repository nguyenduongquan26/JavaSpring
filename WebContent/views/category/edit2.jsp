<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form method="post" modelAttribute="o">
<input type="hidden" name="_csrf" value="${_csrf.token }">
	<form:hidden path="id"/>
	<p>
	<label>Name</label>
	<form:input path="name"/>
	</p>
	<p>
	<label>Parent</label>
	<form:select path="parent">
		<option value="">Select Parent</option>
		<form:options itemValue="id" itemLabel="name" items="${parents}"/>
	</form:select>
	</p>
	<p>
		<button>Save</button>
	</p>
</form:form>