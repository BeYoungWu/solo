<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	
	<div class="container">
		<div class="about">			
			<div class="teachers">
				<div class="row">
				<c:forEach items="${tnf}" var="tnf" varStatus="status">
					<c:if test="${status.index mod 4 == 0}">
						</div><div class="row">
					</c:if>
					<c:if test="${status.index < ts}">
						<div class="col-md-3 col-sm-6">
							<div class="teacher">
								<img class="img-responsive" src="/resources/img/teacher/${tnf.value.savedFileName}" alt="" style="width:260px;height:340px;">
								<h4>${tnf.value.teacherName}</h4>
								<span class="deg">${tnf.value.subject}</span>
							</div>
						</div>
					</c:if>
				</c:forEach>
				</div>
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