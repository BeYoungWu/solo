<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>게시글 작성</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="" />
<meta name="author" content="http://webthemez.com" />
<!-- css -->
<link href="/resources/styles/css/bootstrap.min.css" rel="stylesheet" />
<link href="/resources/styles/css/fancybox/jquery.fancybox.css" rel="stylesheet">
<link href="/resources/styles/css/flexslider.css" rel="stylesheet" />
<link href="/resources/styles/css/style.css" rel="stylesheet" />
<link href="/resources/styles/css/custom/header.css" rel="stylesheet" />
<link href="/resources/styles/css/custom/write.css" rel="stylesheet" />

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
				<h2 class="pageTitle">게시글 작성</h2>
			</div>
		</div>
	</div>
	</section>
	
	<div class="container text-center">		 
		<div class="row">
			<div class="col-lg-12">
			<!-- <form action="write" method="post" enctype="multipart/form-data"> -->
			<form action="write" method="post">
			<table class="table table-bordered">
				<tr>
					<td>제목</td>
					<td><input name="title" maxlength="34" required="required" pattern=".{2,34}" placeholder="2~34자 이내로 입력해주십시오"></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><input name="writer" class="writer" value="${ loginuser.userId }" readonly></td>
				</tr>
				<tr>
					<td>게시판</td>
					<c:choose>
					<c:when test="${ loginuser.userType == 3 || loginuser.userType == 4}">
					<td style="text-align:left;">
						<select name="boardType">
							<option value="none" selected>===선택===</option>
							<option value="0">학교교육계획</option>
							<option value="1">공지사항</option>
							<option value="2">가정통신문</option>
							<option value="3">학교행사</option>
							<option value="4">급식표</option>
							<option value="5">교육복지특별지원사업</option>
							<option value="6">교사마당</option>
							<option value="7">학부모회</option>
							<option value="8">학부모마당자료실</option>
							<option value="9">학생회</option>
							<option value="10">과목별학습자료실</option>
							<option value="11">방과후학교</option>
							<option value="12">도서실</option>
						</select>
					</td>
					</c:when>
					<c:otherwise>
					<td style="text-align:left;">
						<select name="boardType">
							<option value="none" selected>===선택===</option>
							<option value="7">학부모회</option>
							<option value="8">학부모마당자료실</option>
						</select>
					</td>
					</c:otherwise>
					</c:choose>
				</tr>
				<tr>
					<td>첨부파일</td>
					<td><input type="file" name="attach"></td>
				</tr>
				<tr>
					<td style="vertical-align:middle">내용</td>
					<td><textarea name="content" class="content" maxlength="3000" placeholder="3000자 이내로 입력해주십시오"></textarea></td>
				</tr>
			</table>
			<div class="buttons">
				<button type="submit">등록</button>
				<button onclick="history.go(-1)">취소</button>	
			</div>
			</form>
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