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
				<div class="items">
					<div class="item">
						<div class="category">
							<button type="button" onclick=" location.href='/board/list?boardType=${ boardType }' ">
								<c:choose>
								<c:when test="${ boardType == 0 }">
								학교교육계획
								</c:when>
								<c:when test="${ boardType == 1 }">
								공지사항
								</c:when>
								<c:when test="${ boardType == 2 }">
								가정통신문
								</c:when>
								<c:when test="${ boardType == 3 }">
								학교행사
								</c:when>
								<c:when test="${ boardType == 4 }">
								급식표
								</c:when>
								<c:when test="${ boardType == 5 }">
								교육복지특별지원사업
								</c:when>
								<c:when test="${ boardType == 6 }">
								교사마당
								</c:when>
								<c:when test="${ boardType == 7 }">
								학부모회
								</c:when>
								<c:when test="${ boardType == 8 }">
								학부모마당자료실
								</c:when>
								<c:when test="${ boardType == 9 }">
								학생회
								</c:when>
								<c:when test="${ boardType == 10 }">
								과목별학습자료실
								</c:when>
								<c:when test="${ boardType == 11 }">
								방과후학교
								</c:when>
								<c:when test="${ boardType == 12 }">
								도서실
								</c:when>
								</c:choose>
							</button>
						</div>
						<h3>${ board.title }</h3>
					</div>
				</div>
				<div class="items">
					<div class="item">
						${ board.writer }
						&nbsp;
						·
						&nbsp;
						<%-- ${ board.writeDate } --%>
						2023.03.01
						&nbsp;
						·
						&nbsp;
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye" viewBox="0 0 16 16">
						  <path d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.133 13.133 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.133 13.133 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5c-2.12 0-3.879-1.168-5.168-2.457A13.134 13.134 0 0 1 1.172 8z"/>
						  <path d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z"/>
						</svg>
						${ board.readCount }
					</div>
				</div>
				<hr>
				<div class="items">
					<div class="item">
						<!-- 첨부파일 -->
					</div>
				</div>
				<hr>
				<div class="items">
					<div class="item">
						<!-- 첨부파일 -->
					</div>
				</div>
				<div class="items">
					<div class="item">
<c:set var="enter" value="
" />
						${ fn:replace(board.content, enter, "<br>") }
					</div>
				</div>
				<hr>
				<div class="buttons">
					<c:if test="${ not empty loginuser and loginuser.userId eq board.writer }">
					<button type="button" onclick=" location.href='/board/modify?boardType=${ boardType }&boardNo=${ board.boardNo }' ">수정</button>
					<button type="button" onclick=" location.href='/board/delete?boardType=${ boardType }&boardNo=${ board.boardNo }' ">삭제</button>
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