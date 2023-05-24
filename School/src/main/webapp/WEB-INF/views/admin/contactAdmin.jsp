<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<title>문의 관리</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="" />
<meta name="author" content="http://webthemez.com" />

<jsp:include page="/WEB-INF/views/module/admin-common-css.jsp" />
<link href="/resources/styles/css/custom/list.css" rel="stylesheet" />

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
				<h2 class="pageTitle">문의</h2>
			</div>
		</div>
	</div>
	</section>
	
	<div class="container text-center">	
		<div class="row">
			<div class="col-lg-12">
				<table class="table">
					<thead>
					<tr>
						<th style="width:70px;">번호</th>
						<th style="width:60%;">제목</th>
						<th>작성일</th>
						<th>문의자</th>
					</tr>
					</thead>
					<tbody>
					<c:forEach var="contact" items="${ contacts }">
					<c:choose>
					<c:when test="${ contact.checked == 1 }">
					<tr>
						<td>${ contact.contactNo }</td>
						<td style="text-align:left;">
						${ contact.title }
						&nbsp;&nbsp;
						[접수완료]
						</td>
						<td><fmt:formatDate value="${ contact.contactDate }" pattern="yyyy/MM/dd" /></td>
						<td>${ contact.name }</td>
					</tr>
					</c:when>
					<c:otherwise>
					<tr>
						<td>${ contact.contactNo }</td>
						<td style="text-align:left;">
							<a href="contactDetail?contactNo=${ contact.contactNo }" style="color:black;text-decoration:none;">
								${ contact.title }
							</a>
						</td>
						<td><fmt:formatDate value="${ contact.contactDate }" pattern="yyyy/MM/dd" /></td>
						<td>${ contact.name }</td>
					</tr>
					</c:otherwise>
					</c:choose>
					</c:forEach>
					</tbody>
				</table>
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