<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>관리자페이지</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="" />
<meta name="author" content="http://webthemez.com" />

<jsp:include page="/WEB-INF/views/module/admin-common-css.jsp" />
<link href="/resources/styles/css/custom/admin.css" rel="stylesheet" />
 
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
				<h2 class="pageTitle">회원 관리</h2>
			</div>
		</div>
	</div>
	</section>
	
	<div class="contatiner text-center">
		<div class="row">
			<div class="col-lg-12">
				<form id="userType-agree-form" action="/admin/adminUser" method="post">
					<input type="hidden" name="userId">
					<input type="hidden" name="pageNo" value="${ pageNo }">
				</form>
				<table class="table">
					<thead>
					<tr>
						<th>이름</th>
						<th>아이디</th>
						<th>신청회원구분</th>
						<th>회원구분</th>
						<th>신청관리</th>
					</tr>
					</thead>
					<tbody>
					<c:forEach var="user" items="${ users }">
					<tr>
						<td>${ user.userName }</td>
						<td>${ user.userId }</td>
						<td>${ user.wantType }</td>
						<td>${ user.userType }</td>
						<c:choose>
						<c:when test="${ user.wantType eq user.userType }">
						<td>
						완료
						</td>
						</c:when>
						<c:otherwise>
						<td>
						<button class="agree-btn">승인</button>
						</td>
						</c:otherwise>
						</c:choose>
					</tr>
					</c:forEach>
					</tbody>
				</table>
			<br><br>
			
			${ pager }
			
			<br /><br /><br /><br />
			</div>
		</div>
	</div>
	
<jsp:include page="/WEB-INF/views/include/footer.jsp" />
</div>

<%-- JS --%>
<script type="text/javascript">
$(function() {
	$('.agree-btn').on('click', function(event) {
		const tr = $(this).parent().parent();
		const userId = tr.find("td:eq(1)").text();
		
		$('input[name=userId]').val(userId);
		$('#userType-agree-form').submit();
	});
});
</script>
<%-- END --%>

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