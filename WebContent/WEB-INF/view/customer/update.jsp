<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../home/top.jsp"/>
<link rel="stylesheet" href="${css}/customer/mypage.css" />
<div class="grid-item" id="nav">
	<jsp:include page="../employee/nav.jsp"/>
</div>
<!-- <div class="grid-item" id="navi_bar">
	<ul id="navi_bar">
	  <li ><a href="home.do">홈으로</a></li>
	  <li ><a href="#">카테고리</a></li>
	  <li ><a href="#">사원</a></li>
	  <li ><a href="#">주문</a></li>
	  <li ><a href="#">상품</a></li>
	  <li ><a href="#">선박</a></li>
	  <li ><a href="#">공급업체</a></li>
	</ul>
</div>
 -->
<div class="grid-item" id= "side_bar">
	<div class= "myphoto">
	<div class= "myphotoin"><img src="${img}/default_images.jpg"  style="height: 200px; width: 100%; ">
	</div>
	</div>
</div>
<form id="update_form">
<div class="grid-item" id= "content">
<div class ="mypage">
	<div class="grid-container">
	검색한 사람의 정보 <br />
	I   D <br />
	이	름 <br />
	생년월일 <br />
	성	별 <br />
	전화번호 <br />
	지번주소 <br />
	상세주소  <br />
	우편번호  <br />
	임시 비밀번호 <br />
	</div>
	<div >				   
	<br />
	${cust.customerID} <br />
	${cust.customerName} <br />
	${cust.ssn} <br />
	여 <br />
	<input type="text" name="phone" placeholder="${cust.phone}" /> <br />
<%-- 	<input type="hidden" id="_phone" placeholder="${cust.phone}" /> <br /> --%>
	<input type="text" name="city" placeholder="${cust.city}" /> <br />
	<input type="text" name="address" placeholder="${cust.address}" /> <br />
	<input type="text" name="postalCode" placeholder="${cust.postalCode}" /> <br />
	<input type="text" name="password" placeholder="임시 비밀번호" /> <br />
	<input type="hidden" name="customerID" value="${cust.customerID}" />
	<input type="hidden" name="cmd" value="cust_update" />
	<input type="hidden" name="page" value="detail" />
	</div>
</div>
<div class="grid-item">
	<span class="label label-info" id="confirm_btn">확인</span>
	<span class="label label-warning" id="cancel_btn">취소</span>
</div>
</div>
</form>


<jsp:include page="../home/bottom.jsp"/>    
<script>
$('#confirm_btn').attr('style','cursor:pointer').click(()=>{
	alert('확인');
	var form = $('#update_form');
	form.attr('action','${ctx}/customer.do');
	form.attr('method','post');
	form.submit();
});
$('#cancel_btn').click(()=>{
	alert('취소버튼클릭');
	location.assign('${ctx}/customer.do?cmd=cust_retrieve&page=update&customerID=${cust.customerID}')
});

</script>