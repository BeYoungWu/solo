<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>로그인</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="" />
<meta name="author" content="http://webthemez.com" />
<!-- css -->
<link href="/resources/styles/css/bootstrap.min.css" rel="stylesheet" />
<link href="/resources/styles/css/fancybox/jquery.fancybox.css" rel="stylesheet">
<link href="/resources/styles/css/jcarousel.css" rel="stylesheet" />
<link href="/resources/styles/css/flexslider.css" rel="stylesheet" />
<link href="/resources/styles/css/style.css" rel="stylesheet" />
<link href="/resources/styles/css/custom/header.css" rel="stylesheet" />
<link href="/resources/styles/css/custom/login.css" rel="stylesheet" />

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

</head>
<body>
<div id="wrapper">
<jsp:include page="/WEB-INF/views/include/header.jsp" />
	<section id="inner-headline">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<h2 class="pageTitle">로그인</h2>
				</div>
			</div>
		</div>
	</section>
	<div class="container text-center">
		<div class="row">
			<div class="col-lg-12">
				<div class="items">
					<form action="login" method="post" id="login">
						<div class="item">
							<label for="userId">아이디</label>
							<input type="text" name="userId" id="userId">
						</div>
						<div class="item">
							<label for="passwd">비밀번호</label>
							<input type="password" name="passwd" id="passwd">
						</div>
						<button type="submit" id="login_btn">로그인</button>
					</form>
					<br><hr>
					<div class="find">
						<div>
							<a href="/account/findId">아이디 찾기</a>
							/
							<a href="/account/findPasswd">비밀번호 찾기</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<%-----------------------------------------------------------------------------------------------------------------------------------------------------%-->

<%-- JS --%>
<script type="text/javascript">
$(function() {
	<c:if test="${ not empty loginfail }">
	alert('로그인 실패 : 아이디와 패스워드를 확인하세요');
	</c:if>
});
</script>
<%-- JS END --%>
</body>
</html>