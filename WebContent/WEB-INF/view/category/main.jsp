<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../home/top.jsp"/>
<link rel="stylesheet" href="${css}/category/nav.css" />    
<div class="grid-item" id="nav">
	<ul id="navi_bar">
    <li id="nav_item1"><a href="home.do" >홈으로</a></li>
    <li id="nav_item2">
    	<a href="#">${customer.customerName}의 페이지</a>
   	</li>
</ul>
</div>
	<div class="bs-example grid-item" data-example-id="thumbnails-with-custom-content" id="content">
    <div class="row">
      <div class="col-sm-6 col-md-4">
        <div class="thumbnail" >
          <img src="${ctx}/resources/img/samsung_galaxys9.jpg" data-holder-rendered="true" style="height: 200px; width: 100%; display: block;">
          <div class="caption" >
            <h3 id="thumbnail-label">SMART PHONE<a class="anchorjs-link" href="#thumbnail-label"><span class="anchorjs-icon"></span></a></h3>
            <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
            <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
          </div>
        </div>
      </div>
      <div class="col-sm-6 col-md-4">
        <div class="thumbnail" >
 		  <img src="${ctx}/resources/img/samsung_notebook.jpg" data-holder-rendered="true" style="height: 200px; width: 100%; display: block;">	
          <div class="caption">
            <h3 id="thumbnail-label">NOTEBOOK<a class="anchorjs-link" href="#thumbnail-label"><span class="anchorjs-icon"></span></a></h3>
            <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
            <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
          </div>
        </div>
      </div>
      <div class="col-sm-6 col-md-4">
        <div class="thumbnail" >
 		  <img src="${ctx}/resources/img/samsung_desktop.jpg" data-holder-rendered="true" style="height: 200px; width: 100%; display: block;">	
          <div class="caption">
            <h3 id="thumbnail-label">DESKTOP<a class="anchorjs-link" href="#thumbnail-label"><span class="anchorjs-icon"></span></a></h3>
            <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
            <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
          </div>
        </div>
      </div>
    </div>
  </div>
<jsp:include page="../home/bottom.jsp"/>  
<script>
/* $('#emp_register').click(function(){
	location.assign('employee.do?cmd=move&page=register');
});
$('#emp_access').click(function(){
	location.assign('employee.do?cmd=move&page=access')
}); */
$('#nav_item2 a').click(()=>{
	alert('마이페이지 클릭');
	location.assign('${ctx}/customer.do?cmd=cust_retrieve&page=detail&customerID=${customer.customerID}');
});

</script>