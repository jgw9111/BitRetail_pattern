<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../home/top.jsp"/>
<link rel="stylesheet" href="${css}/customer/mypage.css" />
<div class="grid-item" id="nav">
	<jsp:include page="../employee/nav.jsp"/>
</div>

<div class="grid-item" id= "side_bar">
	<div class= "myphoto">
	<div class= "myphotoin"><img src="${img}/default_images.jpg"  style="height: 200px; width: 100%; ">
	</div>
	</div>
</div>
<div class="grid-item" id= "content">
<div class ="mypage">
	<div class ="mypage1">
		검색한 사람의 정보 <br />
		I   D <br />
		이	름 <br />
		생년월일 <br />
		성	별 <br />
		전화번호 <br />
		지번주소 <br />
		상세주소  <br />
		우편번호  <br />
	</div>
	<div class ="mypage2">	
		<br />			   
		${cust.customerID} <br />
		${cust.customerName} <br />
		${cust.ssn} <br />
		여 <br />
		${cust.phone} <br />
		${cust.city} <br />
		${cust.address} <br />
		${cust.postalCode} <br />
		</div>
</div>
<div class="grid-item">
	<span class="label label-info" id="update_btn">수정</span>
	<span class="label label-danger">삭제</span>
</div>
</div>
<jsp:include page="../home/bottom.jsp"/>    
<script>
$('#update_btn').click(function(){
	alert('수정버튼클릭');
	location.assign('${ctx}/customer.do?cmd=cust_retrieve&page=update&customerID=${cust.customerID}');
});
</script>