<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<form class="form" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<p>
	<label>User Name</label>
	<input type="text" name="username" placeholder="User Name">
</p>
<p>
	<label>Password</label>
	<input type="password" name="password" placeholder="Password">
</p>
<p>
	<label>Email</label>
	<input type="email" name="email" placeholder="Email">
</p>
<p>
	<label>Phone number</label>
	<input type="tel" name="tel" placeholder="Phone number">
</p>
<p>
	<label>Address</label>
	<input type="text" name="address" placeholder="Address">
</p>
<p>
	<label>Gender</label>
	<select name="gender">
		<option value="0">Male</option>
		<option value="1">Female</option>
		<option value="2">Undifined</option>
	</select>
</p>
<p>
	<button>Submit</button>
</p>
</form>