<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="" />
<meta name="author" content="http://webthemez.com" />
<%-- CSS --%>
<link href="/resources/styles/css/bootstrap.min.css" rel="stylesheet" />
<link href="/resources/styles/css/fancybox/jquery.fancybox.css" rel="stylesheet">
<!-- <link href="/resources/styles/css/jcarousel.css" rel="stylesheet" /> -->
<link href="/resources/styles/css/flexslider.css" rel="stylesheet" />
<!-- <link href="/resources/styles/js/owl-carousel/owl.carousel.css" rel="stylesheet"> -->
<link href="/resources/styles/css/style.css" rel="stylesheet" />
<link href="/resources/styles/css/custom/home.css" rel="stylesheet" />
<%-- END OF CSS --%>

<%-- HTML5 shim, for IE6-8 support of HTML5 elements --%>
<%--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]--%>

</head>
<body>
	<div id="wrapper">
		<jsp:include page="/WEB-INF/views/include/header.jsp" />
		<section id="featured">

			<%-- SLIDER --%>
			<div id="main-slider" class="flexslider">
				<ul class="slides">
					<li><img src="resources/styles/img/slides/default.jpg" alt="" class="school-image" />
					</li>
					<li><img src="resources/styles/img/slides/1.jpg" alt="" class="school-image" />
						<div class="flex-caption">
							<div class="item_introtext">
								<strong>Online Education</strong>
								<p>The best educational template</p>
							</div>
						</div>
					</li>
					<li><img src="/resources/styles/img/slides/2.jpg" alt="" class="school-image" />
						<div class="flex-caption">
							<div class="item_introtext">
								<strong>School Education</strong>
								<p>Get all courses with on-line content</p>
							</div>
						</div>
					</li>
					<li><img src="/resources/styles/img/slides/3.jpg" alt="" class="school-image" />
						<div class="flex-caption">
							<div class="item_introtext">
								<strong>Collage Education</strong>
								<p>Awesome Template get it know</p>
							</div>
						</div>
					</li>
				</ul>
			</div>
			<%-- END OF SLIDER --%>

		</section>
		<section class="callaction">
			<div class="container">
				<div class="row">
					<div class="col-lg-12">
						<div class="aligncenter">
							<h1 class="aligncenter">Our Featured Courses</h1>
							<span class="clear spacer_responsive_hide_mobile "
								style="height: 13px; display: block;"></span>Lorem ipsum dolor
							sit amet, consectetur adipisicing elit. Dolores quae porro
							consequatur aliquam, incidunt eius magni provident, doloribus
							omnis minus temporibus perferendis nesciunt quam repellendus
							nulla nemo ipsum odit corrupti consequuntur possimus, vero
							mollitia velit ad consectetur. Alias, laborum excepturi nihil
							autem nemo numquam, ipsa architecto non, magni consequuntur quam.
						</div>
					</div>
				</div>
			</div>
		</section>
		<section id="content">


			<div class="container">
				<div class="row">
					<div class="skill-home">
						<div class="skill-home-solid clearfix">
							<div class="col-md-3 text-center">
								<span class="icons c1"><i class="fa fa-trophy"></i></span>
								<div class="box-area">
									<h3>Web Development</h3>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing
										elit. Dolores quae porro consequatur aliquam, incidunt eius
										magni provident</p>
								</div>
							</div>
							<div class="col-md-3 text-center">
								<span class="icons c2"><i class="fa fa-picture-o"></i></span>
								<div class="box-area">
									<h3>UI Design</h3>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing
										elit. Dolores quae porro consequatur aliquam, incidunt eius
										magni provident</p>
								</div>
							</div>
							<div class="col-md-3 text-center">
								<span class="icons c3"><i class="fa fa-desktop"></i></span>
								<div class="box-area">
									<h3>Interaction</h3>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing
										elit. Dolores quae porro consequatur aliquam, incidunt eius
										magni provident</p>
								</div>
							</div>
							<div class="col-md-3 text-center">
								<span class="icons c4"><i class="fa fa-globe"></i></span>
								<div class="box-area">
									<h3>User Experiance</h3>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing
										elit. Dolores quae porro consequatur aliquam, incidunt eius
										magni provident</p>
								</div>
							</div>
						</div>
					</div>
				</div>


			</div>
		</section>
		<div class="testimonial-area">
			<div class="testimonial-solid">
				<div class="container">
					<div class="testi-icon-area">
						<div class="quote">
							<i class="fa fa-microphone"></i>
						</div>
					</div>
					<div id="carousel-example-generic" class="carousel slide"
						data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#carousel-example-generic" data-slide-to="0"
								class=""><a href="#"></a></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"
								class=""><a href="#"></a></li>
							<li data-target="#carousel-example-generic" data-slide-to="2"
								class="active"><a href="#"></a></li>
							<li data-target="#carousel-example-generic" data-slide-to="3"
								class=""><a href="#"></a></li>
						</ol>
						<div class="carousel-inner">
							<div class="item">
								<p>Blanditiis praesentium voluptatum deleniti atque corrupti
									quos dolores et quas molestias excepturi sint occaecati
									cupiditate non provident, similique sunt in culpa qui officia
									deserunt mollitia animi.</p>
								<p>
									<b>- Mark John -</b>
								</p>
							</div>
							<div class="item">
								<p>Blanditiis praesentium voluptatum deleniti atque corrupti
									quos dolores et quas molestias excepturi sint occaecati
									cupiditate non provident, similique sunt in culpa qui officia
									deserunt mollitia animi.</p>
								<p>
									<b>- Jaison Warner -</b>
								</p>
							</div>
							<div class="item active">
								<p>Blanditiis praesentium voluptatum deleniti atque corrupti
									quos dolores et quas molestias excepturi sint occaecati
									cupiditate non provident, similique sunt in culpa qui officia
									deserunt mollitia animi.</p>
								<p>
									<b>- Tony Antonio -</b>
								</p>
							</div>
							<div class="item">
								<p>Blanditiis praesentium voluptatum deleniti atque corrupti
									quos dolores et quas molestias excepturi sint occaecati
									cupiditate non provident, similique sunt in culpa qui officia
									deserunt mollitia animi.</p>
								<p>
									<b>- Leena Doe -</b>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<section class="courses">
			<div class="container">

				<div class="row">
					<div class="col-lg-12">
						<div class="aligncenter">
							<h2 class="aligncenter">
								Courses We Offer
								</h1>
								<span class="clear spacer_responsive_hide_mobile "
									style="height: 13px; display: block;"></span>Lorem ipsum dolor
								sit amet, consectetur adipisicing elit. Dolores quae porro
								consequatur aliquam, incidunt eius magni provident, doloribus
								omnis minus temporibus perferendis nesciunt quam repellendus
								nulla nemo ipsum odit corrupti consequuntur possimus, vero
								mollitia velit ad consectetur. Alias, laborum excepturi nihil
								autem nemo numquam, ipsa architecto non, magni consequuntur
								quam.
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="textbox">
							<h3>Heading Course</h3>
							<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
								Praesent vest sit amet, consec ibulum molestie lacus. Aenean
								nonummy hendrerit mauris. Phasellus porta.</p>
						</div>
					</div>
					<div class="col-md-4">
						<div class="textbox">
							<h3>Heading Course</h3>
							<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
								Praesent vest sit amet, consec ibulum molestie lacus. Aenean
								nonummy hendrerit mauris. Phasellus porta.</p>
						</div>
					</div>
					<div class="col-md-4">
						<div class="textbox">
							<h3>Heading Course</h3>
							<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
								Praesent vest sit amet, consec ibulum molestie lacus. Aenean
								nonummy hendrerit mauris. Phasellus porta.</p>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="textbox">
							<h3>Heading Course</h3>
							<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
								Praesent vest sit amet, consec ibulum molestie lacus. Aenean
								nonummy hendrerit mauris. Phasellus porta.</p>
						</div>
					</div>
					<div class="col-md-4">
						<div class="textbox">
							<h3>Heading Course</h3>
							<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
								Praesent vest sit amet, consec ibulum molestie lacus. Aenean
								nonummy hendrerit mauris. Phasellus porta.</p>
						</div>
					</div>
					<div class="col-md-4">
						<div class="textbox">
							<h3>Heading Course</h3>
							<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
								Praesent vest sit amet, consec ibulum molestie lacus. Aenean
								nonummy hendrerit mauris. Phasellus porta.</p>
						</div>
					</div>
				</div>
			</div>
		</section>
		<jsp:include page="/WEB-INF/views/include/footer.jsp" />
	</div>
	<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>
	<%--------------------------------------------------------------------------------------------%>
	<%-- Placed Java Scripts at the end of the document so the pages load faster --%>
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
	<!-- <script src="/resources/styles/js/owl-carousel/owl.carousel.js"></script> -->
</body>
</html>