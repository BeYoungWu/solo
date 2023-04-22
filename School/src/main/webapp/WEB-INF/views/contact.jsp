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
				<div class="col-md-12">
					<script type="text/javascript"
						src="http://maps.google.com/maps/api/js?sensor=false"></script>
					<div style="overflow: hidden; height: 300px; width: 100%;">
						<div id="gmap_canvas" style="height: 300px; width: 100%;"></div>
						<a class="google-map-code" href="http://www.trivoo.net"
							id="get-map-data">trivoo</a>
					</div>
					<script type="text/javascript">
						function init_map() {
							var myOptions = {
								zoom : 14,
								center : new google.maps.LatLng(40.805478,
										-73.96522499999998),
								mapTypeId : google.maps.MapTypeId.ROADMAP
							};
							map = new google.maps.Map(document
									.getElementById("gmap_canvas"),
									myOptions);
							marker = new google.maps.Marker({
								map : map,
								position : new google.maps.LatLng(
										40.805478, -73.96522499999998)
							});
							infowindow = new google.maps.InfoWindow(
									{
										content : "<b>The Breslin</b><br/>2880 Broadway<br/> New York"
									});
							google.maps.event.addListener(marker, "click",
									function() {
										infowindow.open(map, marker);
									});
							infowindow.open(map, marker);
						}
						google.maps.event.addDomListener(window, 'load',
								init_map);
					</script>

				</div>
			</div>
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
						<form id="contact-form" role="form" novalidate="novalidate">
							<div class="form-group has-feedback">
								<label for="name">Name*</label> <input type="text"
									class="form-control" id="name" name="name" placeholder="">
								<i class="fa fa-user form-control-feedback"></i>
							</div>
							<div class="form-group has-feedback">
								<label for="email">Email*</label> <input type="email"
									class="form-control" id="email" name="email" placeholder="">
								<i class="fa fa-envelope form-control-feedback"></i>
							</div>
							<div class="form-group has-feedback">
								<label for="subject">Subject*</label> <input type="text"
									class="form-control" id="subject" name="subject"
									placeholder=""> <i
									class="fa fa-navicon form-control-feedback"></i>
							</div>
							<div class="form-group has-feedback">
								<label for="message">Message*</label>
								<textarea class="form-control" rows="6" id="message"
									name="message" placeholder=""></textarea>
								<i class="fa fa-pencil form-control-feedback"></i>
							</div>
							<input type="submit" value="Submit" class="btn btn-default">
						</form>
					</div>
				</div>
				<div class="col-md-6">

					<div class="span4">
						<div class="title-box clearfix ">
							<h3 class="title-box_primary">Contact info</h3>
						</div>
						<h5>Lorem ipsum dolor sit amet, cadipisicing sit amet,
							consectetur adipisicing elit. Atque sed, quidem quis
							praesentium.</h5>
						<p>
							Lorem ipsum dolor sit amet, cadipisicing sit amet, consectetur
							adipisicing elit. Lorem ipsum dolor sit amet, cadipisicing sit
							amet, consectetur adipisicing elit. Atque sed, quidem quis
							praesentium Atque sed, quidem quis praesentium, ut unde fuga
							error commodi architecto, laudantium culpa tenetur at id, beatae
							pet.<br>
						</p>
						<address>
							<strong>The Company Name.<br> 12345 St John Point,<br>
								Brisbean, ABC 12 St 11.
							</strong><br> Telephone: +1 234 567 890<br> FAX: +1 234 567 890<br>
							E-mail: <a href="mailto:info@sitename.org">mail@sitename.org</a><br>
						</address>
					</div>
				</div>
			</div>
		</div>

	</section>
<jsp:include page="/WEB-INF/views/include/footer.jsp" />
</div>
<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>
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