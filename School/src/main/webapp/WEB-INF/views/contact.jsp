<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="" />
<meta name="author" content="http://webthemez.com" />
<style>
#gmap_canvas img {
	max-width: none !important;
	background: none !important
}
</style>

<jsp:include page="/WEB-INF/views/module/common-css.jsp" />

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

</head>
<body>
<div id="wrapper">
<jsp:include page="/WEB-INF/views/include/header.jsp" />
	<section id="inner-headline">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<h2 class="pageTitle">문의</h2>
				</div>
			</div>
		</div>
	</section>

	<section id="content">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<br>
					<div class="alert alert-success hidden" id="contactSuccess">
						<strong>Success!</strong> Your message has been sent to us.
					</div>
					<div class="alert alert-error hidden" id="contactError">
						<strong>Error!</strong> There was an error sending your message.
					</div>
					<div class="contact-form">
						<form id="contact-form" action="sendContact">
							<div class="form-group has-feedback">
								<label for="name">이름*</label> <input type="text"
									class="form-control" id="name" name="name" placeholder="">
								<i class="fa fa-user form-control-feedback"></i>
							</div>
							<div class="form-group has-feedback">
								<label for="email">이메일*</label> <input type="email"
									class="form-control" id="email" name="email" placeholder="">
								<i class="fa fa-envelope form-control-feedback"></i>
							</div>
							<div class="form-group has-feedback">
								<label for="title">제목*</label> <input type="text"
									class="form-control" id="title" name="title"
									placeholder=""> <i
									class="fa fa-navicon form-control-feedback"></i>
							</div>
							<div class="form-group has-feedback">
								<label for="content">내용*</label>
								<textarea class="form-control" rows="6" id="content"
									name="content" placeholder=""></textarea>
								<i class="fa fa-pencil form-control-feedback"></i>
							</div>
							<Button type="submit" class="btn">제출</Button>
						</form>
					</div>
				</div>
				<div class="col-md-6">
					<div class="span4">
						<div class="title-box clearfix ">
							<h3 class="title-box_primary">문의 정보</h3>
						</div>
						<h5>무엇을 도와드릴까요?</h5>
						<p>
							저희 xx학교에 대해서 건의하시거나, 문의하고 싶으신 사항을 적어주세요.<br>
							빠른 시일내에 답변 드리도록 하겠습니다.
						</p>
						<address>
							<strong>xx학교<br> 서울특별시 xx구<br>
								xx로 xx길 00-0, xx
							</strong><br> 전화번호: 02 - xxxx - xxxx<br> 팩스번호: 02 - xxxx - xxxx<br>
							이메일: example@example.com</a><br>
						</address>
					</div>
				</div>
			</div>
		</div>
	</section>
	
<jsp:include page="/WEB-INF/views/include/footer.jsp" />
</div>
<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>

<%-- JS --%>
<script type="text/javascript">
// 유효성 검사
</script>

<!-- javascript
   ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="js/jquery.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.fancybox.pack.js"></script>
<script src="js/jquery.fancybox-media.js"></script>
<script src="js/portfolio/jquery.quicksand.js"></script>
<script src="js/portfolio/setting.js"></script>
<script src="js/jquery.flexslider.js"></script>
<script src="js/animate.js"></script>
<script src="js/custom.js"></script>
<script src="js/validate.js"></script>
</body>
</html>