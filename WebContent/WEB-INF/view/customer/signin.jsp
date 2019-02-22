<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../home/top.jsp"/>
<link rel="stylesheet" href="${css}/employee/access.css" />
<div class="grid-item" id="side_menu">
	<h1><font style="font-size: 30px">SIGN-IN</font></h1>
</div>
<div class="grid-item" id="content">
<form id="form" name="form" >
		<div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">I  D</span>
		  <input type="text" class="form-control" placeholder="I  D" aria-describedby="basic-addon1" id="customerID" name="customerID">
	    </div>
		<div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">PASSWORD</span>
		  <input type="text" class="form-control" placeholder="PASSWORD" aria-describedby="basic-addon1" id="password" name="password">
	    </div>
	
	    <button type="button" class="btn btn-default btn-sm" id="confirm_btn" value='SIGN-UP'>
 	 		 <span class="glyphicon glyphicon-ok" aria-hidden="true"></span> CONFRIM
	    </button>
	    <button type="button" class="btn btn-default btn-sm" id="cancel_btn" value='CANCEL'>
 	  		 <span class="glyphicon glyphicon-remove" aria-hidden="true"></span> CANCEL
	    </button>
	    
	    <input type="hidden" name="cmd" value="signin" />
	    <input type="hidden" name="page" value="main" />
	    <input type="hidden" name="dir" value="category" />
	</div>
</form>
<jsp:include page="../home/bottom.jsp"/>
<script>
$('#confirm_btn').click(()=>{
	var customerID = $('#customerID').val();
	var password = $('#password').val();
	$('#form')
	.attr('action', '${ctx}/customer.do')
	.submit();
});
</script>