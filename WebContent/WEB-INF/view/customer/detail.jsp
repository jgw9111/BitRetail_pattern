<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../home/top.jsp"/>
<link rel="stylesheet" href="${css}/customer/mypage.css" />
<link rel="stylesheet" href="${css}/employee/nav.css" />
<div class="grid-item" id="navi_bar">
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

<div class="grid-item" id= "side_bar">
	<div class= "myphoto">
		<div class= "myphotoin"><img src="http://cdn.ddanzi.com/mig-images/865043.jpg"  style="height: 200px; width: 100%; ">
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
${cust.customerID} <br />
${cust.customerName} <br />
${cust.ssn} <br />
여
${cust.phone} <br />
${cust.city} <br />
${cust.address} <br />
${cust.postalCode} <br />
</div>
</div>
</div>
<jsp:include page="../home/bottom.jsp"/>    