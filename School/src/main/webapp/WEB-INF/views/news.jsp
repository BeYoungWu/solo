<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>학교소식</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="" />
<meta name="author" content="http://webthemez.com" />
<!-- css -->
<link href="/resources/styles/css/bootstrap.min.css" rel="stylesheet" />
<link href="/resources/styles/css/fancybox/jquery.fancybox.css" rel="stylesheet">
<link href="/resources/styles/css/flexslider.css" rel="stylesheet" />
<link href="/resources/styles/css/style.css" rel="stylesheet" />
<link href="/resources/styles/css/custom/header.css" rel="stylesheet" />
<link href="/resources/styles/css/custom/news.css" rel="stylesheet" />

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
				<h2 class="pageTitle">알림마당</h2>
			</div>
		</div>
	</div>
	</section>
	
	<div class="container text-center">	
		<div class="row">
			<div class="write-btn">
				<button onclick=" location.href='write' ">글쓰기</button>
			</div>
			<div class="col-lg-12">
			<form>
				<table class="table">
					<thead>
					<tr>
						<th style="width:70px;">번호</th>
						<th style="width:60%;">제목</th>
						<th>작성일</th>
						<th>작성자</th>
						<th style="width:70px">조회수</th>
					</tr>
					</thead>
					<tbody>
					<tr>
						<td><span class="badge rounded-pill text-bg-primary">공지</span></td>
						<td style="text-align:left;">일이삼사오육칠팔구1일이삼사오육칠팔구2일이삼사오육칠팔구3일이삼사오<span class="badge bg-secondary">New</span></h6></td>
						<td>2023/03/04</td>
						<td>홍길동</td>
						<td>1000</td>
					</tr>
					<tr>
						<td>1000</td>
						<td style="text-align:left;">
						일이삼사오육칠팔구십일이삼사오육칠팔구십일이삼사오육칠팔구십
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-paperclip" viewBox="0 0 16 16"><path d="M4.5 3a2.5 2.5 0 0 1 5 0v9a1.5 1.5 0 0 1-3 0V5a.5.5 0 0 1 1 0v7a.5.5 0 0 0 1 0V3a1.5 1.5 0 1 0-3 0v9a2.5 2.5 0 0 0 5 0V5a.5.5 0 0 1 1 0v7a3.5 3.5 0 1 1-7 0V3z"/></svg>
						</td>
						<td>2023/03/04</td>
						<td>홍길동</td>
						<td>1000</td>
					</tr>
					<!--
					<c:forEach var="board" items="${ boards }">
					<tr>
						<td>${ board.boardNo }</td>
						<td>${ board.title }</td>
						<td>${ board.writeDate }</td>
						<td>${ board.writer }</td>
						<td>${ board.readCount }</td>
					</tr>
					</c:forEach>
					 -->
					</tbody>
				</table>
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