<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>교육목표</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="" />
<meta name="author" content="http://webthemez.com" />

<jsp:include page="/WEB-INF/views/module/admin-common-css.jsp" />
<link href="/resources/styles/css/custom/fileAdmin.css" rel="stylesheet" />
 
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
 
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

</head>
<body>
<div id="wrapper">
<jsp:include page="/WEB-INF/views/include/admin-header.jsp" />
	<section id="inner-headline">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h2 class="pageTitle">교육목표</h2>
			</div>
		</div>
	</div>
	</section>
	
	<%-- file 존재하지않을때는 파일등록버튼, file 존재할때는 파일변경버튼 --%>
	<c:choose>
	<c:when test="${ empty file }">
	<div class="registerButton">
		<button data-toggle="modal" data-target="#register-file">파일 등록</button>
	</div>
	</c:when>
	<c:otherwise>
	<div class="modifyButton">
		<button class="modify-btn" data-toggle="modal" data-target="#modify-file">파일 변경</button>
	</div>
	</c:otherwise>
	</c:choose>
	
	<%-- REGISTER MODAL --%>
	<div class="modal fade" id="register-file" tabindex="-1" role="dialog"
		aria-labelledby="exampleMdalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel" style="color: #000;">파일 등록</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body" style="text-align:center">
					<form id="registerPurpose" action="registerPurpose" method="post" enctype="multipart/form-data">
						<div class="filebox">
						    <input class="upload-name" placeholder="사진 파일을 첨부해주십시오*" disabled>
						    <label for="imgFile">파일찾기</label> 
						    <input type="file" name="imgFile" id="imgFile" onchange="fileCheck(this)" accept="image/gif,image/jpeg,image/png">
						</div>
						<br>
						<button type="button" class="btn" data-dismiss="modal">취소</button>
						<button type="submit" class="btn submit" id="btn_register">등록하기</button>
					</form>
				</div>
			</div>
		</div>	
	</div>
	<%-- END --%>
	
	<%-- REGISTER JS --%>
	<script>
	// 첨부파일 선택시 input창에 파일명 뜨게 하기
	$("#imgFile").on('change',function(){
	  var fileName = $("#imgFile").val();
	  $(".upload-name").val(fileName);
	});
	</script>
	<%-- END --%>
	
	<%-- MODIFY MODAL --%>
	<div class="modal fade" id="modify-file" tabindex="-1" role="dialog"
		aria-labelledby="exampleMdalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel" style="color: #000;">파일 수정</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form id="modifyPurpose" action="modifyPurpose" method="post" enctype="multipart/form-data">
				<div>
					등록된 파일 : <input name="prevUserFileName" disabled>
					<input type="hidden" name="prevFileNo">
				</div>
				<br>
				<div class="modal-body" style="text-align:center">
						<div class="filebox">
						    <input class="upload-name" placeholder="수정시에만 파일찾기 클릭*" disabled>
						    <label for="imgFile">파일찾기</label> 
						    <input type="file" name="imgFile" id="imgFile" onchange="fileCheck(this)" accept="image/gif,image/jpeg,image/png">
						</div>
						<br>
						<button type="button" class="btn" data-dismiss="modal">취소</button>
						<button type="submit" class="btn submit" id="btn_modify">등록하기</button>
				</div>
				</form>
			</div>
		</div>	
	</div>
	<%-- END --%>
	
	<%-- MODIFY JS --%>
	<script type="text/javascript">
	$(function() {
		$('.modify-btn').on('click', function(event) { // 클릭한 교사의 데이터 비동기 방식으로 가져오기

			$.ajax({
				"method":"GET",
				"url":"/admin/getPurposeData",
				"data": {},
				"success":function(data, xhr, status){
					$('#modifyPurpose input[name=prevUserFileName]').val(data.userFileName);
					$('#modifyPurpose input[name=prevFileNo]').val(data.fileNo);
				},
				"error":function(request, status, error){
					alert("오류");
					console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				}
			});
			
			// modal 표시
			$('#modify-teacher').modal('show');
		});
	});
	</script>
	<%-- END --%>
	
	<%-- MAIN --%>
	<div class="contatiner">
		<div class="row">
			<div class="col-lg-12">
				<div class="img">
					<img src="/resources/img/purpose/${ file.savedFileName }" alt="">
				</div>
			</div>
		</div>
	</div>
	<%-- END --%>
	
<jsp:include page="/WEB-INF/views/include/footer.jsp" />
</div>
<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>
<!-- javascript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="/resources/styles/js/jquery.js"></script>
<script src="/resources/styles/js/jquery.easing.1.3.js"></script>
<script src="/resources/styles/js/bootstrap.min.js"></script>
<script src="/resources/styles/js/jquery.fancybox.pack.js"></script>
<script src="/resources/styles/js/jquery.fancybox-media.js"></script> 
<script src="/resources/styles/js/portfolio/jquery.quicksand.js"></script>
<script src="/resources/styles/js/portfolio/setting.js"></script>
<script src="/resources/styles/js/jquery.flexslider.js"></script>
<script src="/resources/styles/js/animate.js"></script>
<script src="/resources/styles/js/custom.js"></script>
</body>
</html>