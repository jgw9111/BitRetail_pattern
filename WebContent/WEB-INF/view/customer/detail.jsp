<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../home/top.jsp"/>
<link rel="stylesheet" href="${css}/customer/detail.css" />
<div class="grid-item" id="nav">
	<jsp:include page="../employee/nav.jsp"/>
</div>
<div class="grid-item" id="side_bar">
	<div class= "myphoto">
	<div class= "myphotoin">
	<form id="file_form" >
		<img src="${img}${image.imgName}.${image.imgExtention}" style="height: 200px  ">
		<input type="file" name="file_upload"/>
		<input type="submit" id="file_upload_btn"/>
	</form>
	</div>
	</div>
	<div>
		<span class="label label-info" id="photo_btn">사진수정</span>
	</div>
</div>
<div class="grid-item" id= "content">
<div id="mypage_table">
  <h2>검색한 사람의 정보</h2>  
  <table class="table table-bordered">
    <thead>
      <tr>
             <td>I   D</td>
             <td>${cust.customerID}</td>
           </tr>
           <tr>
             <td>이  름 </td>
             <td>${cust.customerName}</td>
           </tr>
           <tr>
             <td>생년월일 </td>
             <td>${cust.ssn}</td>
           </tr>
           <tr>
             <td>성  별</td>
             <td>여</td>
           </tr>
           <tr>
             <td>전화번호</td>
             <td>${cust.phone}</td>
           </tr>
           <tr>
             <td>지번주소</td>
             <td>${cust.city}</td>
           </tr>
           <tr>
             <td>상세주소</td>
             <td>${cust.address}</td>
           </tr>
           <tr>
             <td>우편번호</td>
             <td>${cust.postalCode}</td>
           </tr>     
    </thead>	
  </table>
</div>

<%-- <div class="grid-item" id ="mypage">
	<div class="grid-item" id ="mypage1">
		검색한 사람의 정보 <br />
		I   D : ${cust.customerID} <br />
		이	름 : ${cust.customerName}<br />
		생년월일 : ${cust.ssn}<br />
		성	별 : 여 <br />
		전화번호 : ${cust.phone}<br />
		지번주소 : ${cust.city}<br />
		상세주소 : ${cust.address}<br />
		우편번호 : ${cust.postalCode} <br />
	</div> --%>
	<!-- <div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">PASSWORD</span>
		  <input type="text" class="form-control" placeholder="PASSWORD" aria-describedby="basic-addon1" id="password" name="password">
    </div> -->
<div class="grid-item">
	<span class="label label-info" id="update_btn">수정</span>
	<span class="label label-danger" id="withdrawal">회원 탈퇴</span>
</div>
</div>
</div>
<jsp:include page="../home/bottom.jsp"/>    
<script>
$('#update_btn').attr('style','cursor:pointer').click(()=>{
	location.assign('${ctx}/customer.do?cmd=cust_retrieve&page=update&customerID=${cust.customerID}');
});
$('#file_upload_btn').attr('style','cursor:pointer').click(()=>{
	$('#file_form')
	.attr('method','post')
	.attr('action','${ctx}/customer.do?cmd=cust_file_upload&page=detail&customerID=${cust.customerID}')
	.attr('enctype','multipart/form-data') 
	.submit(); 
});
$('#withdrawal').attr('style','cursor:pointer').click(()=>{
	alert('탈퇴');
	location.assign('${ctx}/customer.do?cmd=cust_delete&dir=home&page=main&customerID=${cust.customerID}');
});
</script>