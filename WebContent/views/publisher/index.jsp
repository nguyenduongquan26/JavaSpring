<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<form method="post" name="frm">
	<input type="hidden" name="id">
	<p>
		<label>Name</label>
		<input type="text" name="name">
	</p>
	<p>
		<button>Save</button>
	</p>
</form>

<table class="table table-bordered">
	<thead>
		<tr>
			<th>Id</th>
			<th>Name</th>
		</tr>
	</thead>
	<tbody id="rs">
		
	</tbody>
</table>

<script type="text/javascript">
var url= '${pageContext.request.contextPath}/api/publisher/';
$(frm).submit(function(ev){
	ev.preventDefault();
	var o = {'name' : $(frm['name']).val(), 'id': $(frm['id']).val()};
	if(o['id'] != ''){
		//update
		$.ajax({
			'method':'PUT',
			'url':url,
			'dataType':'json',
			'data':o,
			'success':function(r){
				if(r == 1){
					$(frm['id']).val('');
					window.location.reload();
				}
			}
		});
		
	}else{
		$.post(url, o ,function(r){
			if(r == 1){
				window.location.reload();
			}
		});
	}

});
$.get(url,function(l){
	$.each(l,function(i,o){
		$(rs).append('<tr data-id="' + o.id + '"><td>' + o.id + '</td><td>' + o.name +'</td>'+
				'<td><img class="edit" src = "${pageContext.request.contextPath}/images/edit.png"></td><td><img class="del" src = "${pageContext.request.contextPath}/images/trash.png"></td></tr>');
	});
});

$(rs).on('click','.edit',function(){
	var id = $(this).parent().parent().attr('data-id');
	$.get(url + id,function(o){
		$(frm['id']).val(o.id);
		$(frm['name']).val(o.name);
	});
});

$(rs).on('click','.del',function(){
	var id = $(this).parent().parent().attr('data-id');
	var o = {'id': id };
	$.ajax({
		'method': 'DELETE',
		'url': url,
		'dataType':'json',
		'data':o,
		'success' : function(r){
			if(r==1){
				window.location.reload();
			}
		}
	});
});
</script>