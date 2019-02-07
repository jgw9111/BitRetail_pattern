<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../home/top.jsp"/>
<link rel="stylesheet" href="${css}/customer/signup.css" />
<div class="grid-item" id="side_menu">
 	<h1><font style="font-size: 30px">SIGN-UP</font></h1>
</div>
<div class="grid-item" id="content">
<form id="form" name="form" >
	<div class="grid-container">
	<!-- customerID, customerName, contactName , address, city, postalCode, county -->
      <div class="grid-item" id="item_1">I  D</div>
      <div class="grid-item" id="item_2"><input type="text" id="customerID" name="customerID" ></div>
      <div class="grid-item" id="item_3">NAME</div>
      <div class="grid-item" id="item_4"><input type="text" id="customerName" name="customerName" ></div>
      <div class="grid-item" id="item_5">PASSWORD</div>
      <div class="grid-item" id="item_6"><input type="text" id="password" name="password" ></div>
      <div class="grid-item" id="item_7">SSN</div>
      <div class="grid-item" id="item_8"><input type="text" id="ssn" name="ssn" ></div>
      <div class="grid-item" id="item_9">CITY</div>
      <div class="grid-item" id="item_10"><input type="text" id="city" name="city" ></div>
      <div class="grid-item" id="item_11">POSTALCODE</div>
      <div class="grid-item" id="item_12"><input type="text" id="postalCode" name="postalCode" ></div>
      <div class="grid-item" id="item_13">ADDRESS</div>
      <div class="grid-item" id="item_14"><input type="text" id="address" name="address" ></div>
      <div class="grid-item" id="item_15"><input type="submit" id="confirm_btn" value='SIGN-UP'></div>
      <div class="grid-item" id="item_16"><input type="reset" id="cancel_btn" value='CANCEL'> </div>
      <input type="hidden" name="cmd" value="signup" />
      <input type="hidden" name="page" value="signin" />
	</div>
</form>
</div>
<jsp:include page="../home/bottom.jsp"/>
<script>
$('#confirm_btn').click(function(){
	var customerID = $('#customerID').val();
	var customerName = $('#customerName').val();
	var password = $('#password').val();
	var ssn = $('#ssn').val();
	var city = $('#city').val();
	var postalCode = $('#postalCode').val();
	var address = $('#address').val();
	$('#form')
	.attr('action', '${ctx}/customer.do')
	.submit();
});
</script>