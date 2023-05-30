<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<title>게시글 목록</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="" />
<meta name="author" content="http://webthemez.com" />

<jsp:include page="/WEB-INF/views/module/common-css.jsp" />
<link href="/resources/styles/css/custom/list.css" rel="stylesheet" />

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
			<c:choose>
			<c:when test="${ boardType eq 0 or boardType eq 1 or boardType eq 2 or boardType eq 3 or boardType eq 4 or boardType eq 5 or boardType eq 6 or boardType eq 9 or boardType eq 10 or boardType eq 11 or boardType eq 12 }">
			<c:if test="${ not empty loginuser and loginuser.userType eq 3 or loginuser.userType eq 4 }">
			<div class="write-btn">
				<button onclick=" location.href='/board/write?boardType=${ boardType }' ">글쓰기</button>
			</div>
			</c:if>
			</c:when>
			<c:when test="${ boardType eq 7 or boardType eq 8 }">
			<c:if test="${ not empty loginuser and loginuser.userType eq 2 or loginuser.userType eq 3 or loginuser.userType eq 4 }">
			<div class="write-btn">
				<button onclick=" location.href='/board/write?boardType=${ boardType }' ">글쓰기</button>
			</div>
			</c:if>
			</c:when>
			</c:choose>
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
					<c:forEach var="board" items="${ boards }">
					<c:choose>
					<c:when test="${ board.fileNo != 0 }">
					<tr>
						<td>${ board.boardNo }</td>
						<td style="text-align:left;">
							<a href="detail?boardType=${ boardType }&boardNo=${ board.boardNo }" style="color:black;text-decoration:none;">
								${ board.title }
							</a>
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-paperclip" viewBox="0 0 16 16"><path d="M4.5 3a2.5 2.5 0 0 1 5 0v9a1.5 1.5 0 0 1-3 0V5a.5.5 0 0 1 1 0v7a.5.5 0 0 0 1 0V3a1.5 1.5 0 1 0-3 0v9a2.5 2.5 0 0 0 5 0V5a.5.5 0 0 1 1 0v7a3.5 3.5 0 1 1-7 0V3z"/></svg>
						</td>
						<td><fmt:formatDate value="${ board.writeDate }" pattern="yyyy/MM/dd" /></td>
						<td>${ board.writer }</td>
						<td>${ board.readCount }</td>
					</tr>
					</c:when>
					<c:otherwise>
					<tr>
						<c:choose>
						<c:when test="${ board.notice eq 'true' }">
						<td>
						<span class="badge text-bg-secondary">공지</span>
						</td>
						</c:when>
						<c:otherwise>
						<td>${ board.boardNo }</td>
						</c:otherwise>
						</c:choose>
						<td style="text-align:left;">
							<a href="detail?boardType=${ boardType }&boardNo=${ board.boardNo }&pageNo=${ pageNo }" style="color:black;text-decoration:none;">
								${ board.title }
							</a>
						</td>
						<td><fmt:formatDate value="${ board.writeDate }" pattern="yyyy/MM/dd" /></td>
						<td>${ board.writer }</td>
						<td>${ board.readCount }</td>
					</tr>
					</c:otherwise>
					</c:choose>
					</c:forEach>
					</tbody>
				</table>
			</form>
			<br><br>
			
			${ pager }
			
			<br /><br /><br /><br />
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