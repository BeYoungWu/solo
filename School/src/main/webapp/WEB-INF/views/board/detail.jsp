<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
<link href="/resources/styles/css/custom/detail.css" rel="stylesheet" />

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
				<c:choose>
				<c:when test="${ boardType == 0 }">
				<h2 class="pageTitle">학교교육계획</h2>
				</c:when>
				<c:when test="${ boardType == 1 }">
				<h2 class="pageTitle">공지사항</h2>
				</c:when>
				<c:when test="${ boardType == 2 }">
				<h2 class="pageTitle">가정통신문</h2>
				</c:when>
				<c:when test="${ boardType == 3 }">
				<h2 class="pageTitle">학교행사</h2>
				</c:when>
				<c:when test="${ boardType == 4 }">
				<h2 class="pageTitle">급식표</h2>
				</c:when>
				<c:when test="${ boardType == 5 }">
				<h2 class="pageTitle">교육복지특별지원사업</h2>
				</c:when>
				<c:when test="${ boardType == 6 }">
				<h2 class="pageTitle">교사마당</h2>
				</c:when>
				<c:when test="${ boardType == 7 }">
				<h2 class="pageTitle">학부모회</h2>
				</c:when>
				<c:when test="${ boardType == 8 }">
				<h2 class="pageTitle">학부모마당자료실</h2>
				</c:when>
				<c:when test="${ boardType == 9 }">
				<h2 class="pageTitle">학생회</h2>
				</c:when>
				<c:when test="${ boardType == 10 }">
				<h2 class="pageTitle">과목별학습자료실</h2>
				</c:when>
				<c:when test="${ boardType == 11 }">
				<h2 class="pageTitle">방과후학교</h2>
				</c:when>
				<c:when test="${ boardType == 12 }">
				<h2 class="pageTitle">도서실</h2>
				</c:when>
				</c:choose>
			</div>
		</div>
	</div>
	</section>
	
	<div class="container text-center">		 
		<div class="row">
			<div class="col-lg-12">
			<table class="table table-bordered">
				<tr>
					<td>제목</td>
					<td>${ board.title }</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td>${ board.writer }</td>
				</tr>
				<tr>
					<td>조회수</td>
					<td>${ board.readCount }</td>
				</tr>
				<tr>
					<td>첨부파일</td>
					<td></td>
				</tr>
				<tr>
					<td style="vertical-align:middle">내용</td>
					<td>
<c:set var="enter" value="
" />
						${ fn:replace(board.content, enter, "<br>") }
					</td>
				</tr>
			</table>
			<div class="buttons">
				<c:if test="${ not empty loginuser and loginuser.userId eq board.writer }">
				<button>수정</button>
				<button>삭제</button>
				</c:if>
				<button type="button" onclick=" location.href='/board/list?boardType=${ boardType }' ">목록으로</button>
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