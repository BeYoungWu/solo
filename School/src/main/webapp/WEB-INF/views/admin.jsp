<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자페이지</title>
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
				<h2 class="pageTitle">관리자 페이지</h2>
			</div>
		</div>
	</div>
	</section>
	
	<div class="contatiner">
		<div class="row">
			<div class="col-lg-12">
			<h2>학교소개 - 등록 / 수정 관리</h2>
			<h2>게시판 - 공지 등록 / 게시물 관리</h2>				
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