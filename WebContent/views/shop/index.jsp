<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<form method="post" name="frm">
	<p>
	<label>ISBN</label>
	<input type="text" name="isbn">
	</p>
	<p>
	<button class="btn btn-primary">Search</button>
	</p>
</form>


<form method="post" action="${pageContext.request.contextPath}/shop/add.html">
	<p>
	<label>Email</label>
	<input type="email" name="email" value="quan@gmail.com">
	</p>
	<p>
	<label>Tel</label>
	<input type="tel" name="tel" value="0902975">
	</p>
	<p>
	<label>Address</label>
	<input type="text" name="address" value="TP.HCM">
	</p>
	<p>
	<button class="btn btn-primary">Save</button>
	</p>

	<table class="table table-bordered">
		<thead>
			<tr>
				<td>Title</td>
				<td>Price</td>
				<td>Quantity</td>
				<td>Image</td>
			</tr>		
		</thead>
		<tbody id="rs">
		
		</tbody>
	</table>
</form>
<script type="text/javascript">
$(frm).submit(function(ev){
	ev.preventDefault();
	var o = {'isbn': $(frm['isbn']).val()};
	$.post('${pageContext.request.contextPath}/api/product', o ,function(d){
		var s = '<tr><td>{0}<input type="hidden" value="{3}" name="id"</td><td>{1}<input type="hidden" value="{1}" name="price"></td><td><input type="number" min="1" value="1" name="quantity"></td><td><img width="200" src = "${pageContext.request.contextPath}/images/{2}"></td></tr>';
		$(rs).append(String.format(s,d.title,d.price,d.imageURL,d.id));
	});
});
</script>
