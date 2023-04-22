<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교직원소개</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="" />
<meta name="author" content="http://webthemez.com" />

<jsp:include page="/WEB-INF/views/module/common-css.jsp" />
 
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
				<h2 class="pageTitle">교직원 소개</h2>
			</div>
		</div>
	</div>
	</section>
	<section id="content">
	<div class="container">
					
			<div class="about">			
				
				<!-- Our team starts -->
				
				<div class="teachers">
					<div class="row">
						<div class="col-md-3 col-sm-6">
							<!-- Team Member -->
							<div class="team-member">
								<!-- Image -->
								<img class="img-responsive" src="/resources/styles/img/team1.jpg" alt="">
								<!-- Name -->
								<h4>Johne Doe</h4>
								<span class="deg">Creative</span> 
							</div>
						</div>
						<div class="col-md-3 col-sm-6">
							<!-- Team Member -->
							<div class="team-member">
								<!-- Image -->
								<img class="img-responsive" src="/resources/styles/img/team2.jpg" alt="">
								<!-- Name -->
								<h4>Jennifer</h4>
								<span class="deg">Programmer</span> 
							</div>
						</div>
						<div class="col-md-3 col-sm-6">
							<!-- Team Member -->
							<div class="team-member">
								<!-- Image -->
								<img class="img-responsive" src="/resources/styles/img/team3.jpg" alt="">
								<!-- Name -->
								<h4>Christean</h4>
								<span class="deg">CEO</span> 
							</div>
						</div>
						<div class="col-md-3 col-sm-6">
							<!-- Team Member -->
							<div class="team-member">
								<!-- Image -->
								<img class="img-responsive" src="/resources/styles/img/team4.jpg" alt="">
								<!-- Name -->
								<h4>Kerinele rase</h4>
								<span class="deg">Manager</span> 
							</div>
						</div>
					</div>
				</div>
				
				<!-- Our team ends -->
			  
				
			</div>
			
		</div>
	</section>
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