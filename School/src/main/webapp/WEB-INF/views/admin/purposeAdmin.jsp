<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교육목표</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="" />
<meta name="author" content="http://webthemez.com" />

<jsp:include page="/WEB-INF/views/module/admin-common-css.jsp" />
 
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
	
	<div class="registerButton">
		<button data-toggle="modal" data-target="#register-file">파일 등록</button>
	</div>
	
	<%-- REGISTER PURPOSE MODAL --%>
	<div class="modal fade" id="register-purpose" tabindex="-1" role="dialog"
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
					<form id="registerPurpose" action="registerPurpose" method="post" class="insert-menu-form" enctype="multipart/form-data">
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
	
	<%-- REGISTER PURPOSE JS --%>
	<script>
	// 첨부파일 선택시 input창에 파일명 뜨게 하기
	$("#imgFile").on('change',function(){
	  var fileName = $("#imgFile").val();
	  $(".upload-name").val(fileName);
	});
	</script>
	<%-- END --%>
	
	<div class="contatiner">
		<div class="row">
			<div class="col-lg-12">
				<img src="/resources/img/history/${ file.savedFileName }" alt="">
			</div>
		</div>
	</div>
	
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