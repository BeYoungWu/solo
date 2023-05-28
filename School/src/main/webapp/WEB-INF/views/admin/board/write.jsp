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

<jsp:include page="/WEB-INF/views/module/admin-common-css.jsp" />
<link href="/resources/styles/css/custom/write.css" rel="stylesheet" />

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
				<h2 class="pageTitle">게시글 작성</h2>
			</div>
		</div>
	</div>
	</section>
	
	<div class="container text-center">		 
		<div class="row">
			<div class="col-lg-12">
			<form action="write" id="submit-form" method="post" enctype="multipart/form-data">
			<table class="table table-bordered">
				<tr>
					<td style="vertical-align:middle">게시글 분류</td>
					<td>
					<label><input type="radio" name="notice" value="true" checked>공지</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label><input type="radio" name="notice" value="false">일반</label>
					</td>
				</tr>
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
						<% String boardType=request.getParameter("boardType"); %>
						<select name="boardType">
							<option value=null>===선택===</option>
							<option value="0" <%="0".equals(boardType)?"selected":""%>>학교교육계획</option>
							<option value="1" <%="1".equals(boardType)?"selected":""%>>공지사항</option>
							<option value="2" <%="2".equals(boardType)?"selected":""%>>가정통신문</option>
							<option value="3" <%="3".equals(boardType)?"selected":""%>>학교행사</option>
							<option value="4" <%="4".equals(boardType)?"selected":""%>>급식표</option>
							<option value="5" <%="5".equals(boardType)?"selected":""%>>교육복지특별지원사업</option>
							<option value="6" <%="6".equals(boardType)?"selected":""%>>교사마당</option>
							<option value="7" <%="7".equals(boardType)?"selected":""%>>학부모회</option>
							<option value="8" <%="8".equals(boardType)?"selected":""%>>학부모마당자료실</option>
							<option value="9" <%="9".equals(boardType)?"selected":""%>>학생회</option>
							<option value="10" <%="10".equals(boardType)?"selected":""%>>과목별학습자료실</option>
							<option value="11" <%="11".equals(boardType)?"selected":""%>>방과후학교</option>
							<option value="12" <%="12".equals(boardType)?"selected":""%>>도서실</option>
						</select>
					</td>
					</c:when>
					<c:otherwise>
					<td style="text-align:left;">
						<% String boardType=request.getParameter("boardType"); %>
						<select name="boardType">
							<option value=null>===선택===</option>
							<option value="7" <%="7".equals(boardType)?"selected":""%>>학부모회</option>
							<option value="8" <%="8".equals(boardType)?"selected":""%>>학부모마당자료실</option>
						</select>
					</td>
					</c:otherwise>
					</c:choose>
				</tr>
				<tr>
					<td>첨부파일</td>
					<td><input type="file" name="file" id="file" onchange="setDetailImage(event);"></td>
				</tr>
				<tr>
					<td colspan="2">
						<div id="images_container"></div>
					</td>
				</tr>
				<tr>
					<td style="vertical-align:middle">내용</td>
					<td>
					<textarea name="content" class="content" maxlength="3000" placeholder="3000자 이내로 입력해주십시오">
					</textarea>
					</td>
				</tr>
			</table>
			<div class="buttons"> 
				<button type="submit" id="submit">등록</button>
				<button type="button" onclick=" location.href='/admin/board/list?boardType=${ boardType }' ">취소</button>
			</div>
			</form>
			</div>
   		</div>
	</div>
</div>

<script>
// 첨부파일 미리보기
function setDetailImage(event) {
  var file = event.target.files[0];
  var container = document.getElementById('images_container');

  // 이전에 표시된 이미지 삭제
  container.innerHTML = '';

  // 선택된 파일의 미리보기 이미지 표시
  if (file && file.type.startsWith('image/')) {
    var reader = new FileReader();

    reader.onload = function (e) {
      var img = document.createElement('img');
      img.src = e.target.result;
      img.classList.add('preview-image');
      container.appendChild(img);
    };

    reader.readAsDataURL(file);

    // 이미지 미리보기 행 보이기
    document.getElementById('preview-row').style.display = 'table-row';
  } else {
    // 이미지 미리보기 행 숨기기
    document.getElementById('preview-row').style.display = 'none';
  }
}

// 파일 선택 이벤트 감지
document.getElementById('file-input').addEventListener('change', setDetailImage);

// 등록 버튼 클릭시 alert
$("#submit").on('click', function(){
	const ok = confirm("등록하시겠습니까?");
	if (!ok) return false;
	
});

// 등록 완료시 alert
$("#submit-form").submit('#submit', function(e){
	alert("등록이 완료되었습니다");
});

</script>

<jsp:include page="/WEB-INF/views/include/footer.jsp" />

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