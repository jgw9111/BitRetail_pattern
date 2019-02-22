<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<jsp:include page="../home/top.jsp"/>
<link rel="stylesheet" href="${css}/customer/list.css" />
<div class="grid-item" id="nav">
	<jsp:include page="../employee/nav.jsp"/>
</div>
<div class="grid-item" id="side_menu">
	<div class="container" style="width: 200px;">
	  <ul class="list-group" id="cate_tab">
	    <li class="list-group-item" id="cate_list" style="background-color: #bde4e4; ">카테고리 목록</li>
	    <li class="list-group-item" id="cate_register">카테고리 등록</li>
	    <li class="list-group-item" id="cate_search">카테고리 조회</li>
	    <li class="list-group-item" id="cate_update">카테고리 수정</li>
	    <li class="list-group-item" id="cate_delete">카테고리 삭제</li>
	  </ul>
	</div>
</div>
<div class="grid-item" id="content">
	<table id="cust_tab">
	  <tr>
	    <th>No.</th>
	    <th>카테고리 아이디</th>
	    <th>카테고리 설	 명</th>
	  </tr>
	<c:forEach items="${list}" var="cate" >
	  <tr>
	    <td>${cate.categoryId}</td>
	    <td>${cate.categoryName}</td>
	    <td><a href="#">${cate.description}</a></td>
	  </tr>
	</c:forEach>
	</table>
<div style="height: 50px"></div>    
	<%-- <div class="center">
	  <div class="pagenation">
	  <c:if test="${pagenation.existPrev}">
		  <a href="${ctx}/customer.do?cmd=cust_list&page=list&page_num=${pagenation.prevBlock}">&laquo;</a>
	  </c:if>
	  <c:forEach begin="${pagenation.startPage}" end="${pagenation.endPage}" varStatus="status" >
		  <c:choose>
		  	<c:when test="${pagenation.pageNum eq status.index}">
			  <a href="#" class ="page active">${status.index}</a>
		  	</c:when>
            <c:otherwise>
			  <a href="#" class ="page">${status.index}</a>
            </c:otherwise>
		  </c:choose>
	  </c:forEach>
	  <c:if test="${pagenation.existNext}">
		  <a href="${ctx}/customer.do?cmd=cust_list&page=list&page_num=${pagenation.nextBlock}">&raquo;</a>
	  </c:if>
	  </div>
	</div> --%>
</div>

<jsp:include page="../home/bottom.jsp"/>
<script>
 	$('.page').click(()=>{
		location.assign('${ctx}/customer.do?cmd=cust_list&page=list&page_num='+$(this).text());
		});
 	$('#cate_register').attr('style','cursor:pointer').click(()=>{	
 		$('#cate_tab > li').attr('style','background-color: white');
 		$('#cate_register').attr('style','background-color: #bde4e4');
 		$('#content').html('<form id="form">'
 				+'  <div class="form-group">'
 				+'    <label for="text">카테고리이름:</label> <br />'
 				+'    <input type="text" class="form-control" name="cate_name">'
 				+'  </div>'
 				+'  <div class="form-group">'
 				+'    <label for="text">상세 설명:</label>'
 				+'    <textarea rows="3" cols="60" class="form-control" name="dsecription">'
 				+'    </textarea>'
 				+'  </div>'
 				+'  <button type="submit" class="btn btn-default">Submit</button>'
 				+'</form>');
 	});
 	$('#cate_search').attr('style','cursor:pointer').click(()=>{	
 		$('#cate_tab > li').attr('style','background-color: white');
 		$('#cate_register').attr('style','background-color: #bde4e4');
 		$('#content').html('<form id="form">'
 				+'  <div class="form-group">'
 				+'    <label for="text">카테고리검색:</label> <br />'
 				+'    <select>'
				+'    <option name="cate_id" value="1002">SMART_PHONE</option>'
 				+'    <option name="cate_id" value="1020">DESKTOP</option>'
 				+'    <option name="cate_id" value="1021">Laptop</option>'
 				+'    </select>'
 				+'  </div>'
 				+'  <button type="submit" class="btn btn-default">Submit</button>'
 				+'</form>');
 	});
 	$('#cate_delete').attr('style','cursor:pointer').click(()=>{	
 		$('#cate_tab > li').attr('style','background-color: white');
 		$('#cate_delete').attr('style','background-color: #bde4e4');
 		$('#content').html('<form id="form">'
 				+'  <div class="form-group">'
 				+'    <label for="text">카테고리삭제:</label> <br />'
				+'    <input type="checkbox" name="cate_id" value="1002"> SMART_PHONE<br>'
 				+'    <input type="checkbox" name="cate_id" value="1020"> DESKTOP<br>'
 				+'    <input type="checkbox" name="cate_id" value="1021"> Laptop<br>'
 				+'  </div>'
 				+'  <button type="submit" class="btn btn-default">Delete</button>'
 				+'</form>');
 	});
 	$('#cate_update').attr('style','cursor:pointer').click(()=>{
 		$('#cate_tab > li').attr('style','background-color: white');
 		$('#cate_update').attr('style','background-color: #bde4e4');
 		$('#content').html('<form id="form">'
 				+'  <div class="form-group">'
 				+'    <label for="text">카테고리수정:</label> <br />'
 				+'    <input type="radio" name="gender" value="male"> 스마트폰<br>'
 				+'    <input type="radio" name="gender" value="female"> 데스크탑<br>'
 				+'    <input type="radio" name="gender" value="other"> 노트북 <br />'
				+'     <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">수정</button><br />'
				+'		<div class="modal fade" id="myModal" role="dialog">'
				+'		<div class="modal-dialog">'
				+'    <div class="modal-content">'
 				+'    <div class="modal-header">'
 				+'    <button type="button" class="close" data-dismiss="modal">&times;</button>'
 				+'    <h4 class="modal-title">카테고리 수정</h4>'
 				+'    </div>' //modal-header
 				+'    <div class="modal-body">'
 				+'    <p>카테고리 이름</p>'
 				+'    <textarea rows="2" cols="30" class="form-control" name="dsecription">'
 				+'    </textarea>'
 				+'    <p>카테고리 상세</p>'
 				+'    <textarea rows="2" cols="30" class="form-control" name="dsecription">'
 				+'    </textarea>'
 				+'   </div>' //modal-body
 				+'   <div class="modal-footer">'
 				+'   <button type="button" class="btn btn-default" data-dismiss="modal">Confirm</button>'
 				+'  </div>' //modal-footer
 				+'  </div>' //content
 				+'  </div>' //form group
 				+'  </div>' //form group
 				+'  </div>' //form group
 				+'</form>');
 	});
 	

</script>