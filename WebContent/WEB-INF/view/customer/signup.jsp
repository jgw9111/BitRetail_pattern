<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../home/top.jsp"/>
<link rel="stylesheet" href="${css}/customer/signup.css" />
<div class="grid-item" id="side_menu">
 	<h1><font style="font-size: 30px">SIGN-UP</font></h1>
</div>
<div class="grid-item" id="content">
<form id="form" name="form" >
	<!-- <div class="grid-container"> -->
	<!-- customerID, customerName, contactName , address, city, postalCode, county -->
      <div class="input-group" >
		  <span class="input-group-addon" id="basic-addon1" >I  D</span>
		  <input type="text" class="form-control" placeholder="I  D" aria-describedby="basic-addon1" id="customerID" name="customerID">
	  </div>
      <div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">NAME</span>
		  <input type="text" class="form-control" placeholder="NAME" aria-describedby="basic-addon1" id="customerName" name="customerName">
	  </div>
      <div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">PASSWORD</span>
		  <input type="text" class="form-control" placeholder="PASSWORD" aria-describedby="basic-addon1" id="password" name="password">
	  </div>
      <div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">SSN</span>
		  <input type="text" class="form-control" placeholder="SSN" aria-describedby="basic-addon1" id="ssn" name="ssn">
	  </div>
      <div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">PHONE</span>
		  <input type="text" class="form-control" placeholder="PHONE" aria-describedby="basic-addon1" id="phone" name="phone">
	  </div>
      <div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">CITY</span>
		  <input type="text" class="form-control" placeholder="CITY" aria-describedby="basic-addon1" id="city" name="city">
	  </div>
      <div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">ADDRESS</span>
		  <input type="text" class="form-control" placeholder="ADDRESS" aria-describedby="basic-addon1" id="address" name="address" >
	  </div>
      <div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">POSTALCODE</span>
		  <input type="text" class="form-control" placeholder="POSTALCODE" aria-describedby="basic-addon1" id="postalCode" name="postalCode" >
	  </div>
	  <button type="button" class="btn btn-default btn-sm" id="confirm_btn" value='SIGN-UP'>
 	 	 <span class="glyphicon glyphicon-ok" aria-hidden="true"></span> CONFRIM
	  </button>
	  <button type="button" class="btn btn-default btn-sm" id="cancel_btn" value='CANCEL'>
 	 	 <span class="glyphicon glyphicon-remove" aria-hidden="true"></span> CANCEL
	  </button>
      <input type="hidden" name="cmd" value="signup" />
      <input type="hidden" name="page" value="signin" />
	<!-- </div> -->
</form>
</div>
<jsp:include page="../home/bottom.jsp"/>
<script>
$('#confirm_btn').click(()=>{
	var customerID = $('#customerID').val();
	var customerName = $('#customerName').val();
	var password = $('#password').val();
	var ssn = $('#ssn').val();
	var phone = $('#phone').val();
	var city = $('#city').val();
	var address = $('#address').val();
	var postalCode = $('#postalCode').val();
	$('#form')
	.attr('action', '${ctx}/customer.do')
	.submit();
});
</script>