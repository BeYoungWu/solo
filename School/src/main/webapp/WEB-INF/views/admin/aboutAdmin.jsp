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

<jsp:include page="/WEB-INF/views/module/admin-common-css.jsp" />
<link href="/resources/styles/css/custom/aboutAdmin.css" rel="stylesheet" />

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
				<h2 class="pageTitle">교직원 소개</h2>
			</div>
		</div>
	</div>
	</section>
	<div class="buttons">
		<button data-toggle="modal" data-target="#register-teacher">교사 등록</button>
	</div>
	
	<%-- REGISTER TEACHER MODAL --%>
	<div class="modal fade" id="register-teacher" tabindex="-1" role="dialog"
		aria-labelledby="exampleMdalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel" style="color: #000;">교사 등록</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body" style="text-align:center">
					<form id="registerTeacher" action="registerTeacher" method="post" class="insert-menu-form" enctype="multipart/form-data">
						<div class="input-grids">
							<input type="text" name="teacherName" id="teacherName"
								placeholder="교사 성함*" class="form-control" required="required">
							<br>
							<select id="subjectSelbox" name="subjectCategory">
							  <option selected>교사의 과목을 선택해주십시오*</option>
							  <c:forEach var="subject" items="${ subjects }">
							  <option value="${ subject }">${ subject }</option>
							  </c:forEach>
							  <option value="direct">직접입력</option>
							</select>
							<br>
							<input type="text" class="form-control" placeholder="교사 과목*" id="subjectSelboxDirect" name="subjectSelboxDirect" style="margin-top:22px">
						</div>
						<br>
						<div class="filebox">
						    <input class="upload-name" placeholder="교사 사진을 첨부해주십시오*" disabled>
						    <label for="teacherImg">파일찾기</label> 
						    <input type="file" name="teacherImg" id="teacherImg" onchange="fileCheck(this)" accept="image/gif,image/jpeg,image/png">
						</div>
						<br>
						<button type="button" class="btn" data-dismiss="modal">취소</button>
						<button type="submit" class="btn submit" id="btn_register_teacher">등록하기</button>
					</form>
				</div>
			</div>
		</div>	
	</div>
	<%-- END --%>
	
	<%-- RESGISTER TEACHER JS --%>
	<script>
	// 교사 과목 select box
	$("#subjectSelboxDirect").hide();
	
	$("#subjectSelbox").change(function() {
		$("#subjectSelboxDirect").val('');
		// 직접입력을 누를 때 나타남
		if ($("#subjectSelbox").val() == "direct") {
			$("#subjectSelboxDirect").show();
		} else {
			$("#subjectSelboxDirect").hide();
		}
	});

	// 첨부파일 선택시 input창에 파일명 뜨게 하기
	$("#teacherImg").on('change',function(){
	  var fileName = $("#teacherImg").val();
	  $(".upload-name").val(fileName);
	});
	</script>
	<%-- END --%>
	
	
	<%-- MODIFY SUBJECT MODAL --%>
	<div class="modal fade" id="modify-teacher" tabindex="-1" role="dialog"
		aria-labelledby="exampleMdalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel" style="color: #000;">교사 등록</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body" style="text-align:center">
					<form id="registerTeacher" action="registerTeacher" method="post" class="insert-menu-form" enctype="multipart/form-data">
						<div class="input-grids">
							<input type="text" name="teacherName" id="teacherName"
								placeholder="교사 성함*" class="form-control" required="required">
							<br>
							<select id="modifySubjectSelbox" name="subjectCategory">
							  <option selected>교사의 과목을 선택해주십시오*</option>
							  <c:forEach var="subject" items="${ subjects }">
							  <option value="${ subject }">${ subject }</option>
							  </c:forEach>
							  <option value="direct">직접입력</option>
							</select>
							<br>
							<input type="text" class="form-control" placeholder="교사 과목*" id="modifySubjectSelboxDirect" name="subjectSelboxDirect" style="margin-top:22px">
						</div>
						<br>
						<div class="filebox">
						    <input class="upload-name" placeholder="교사 사진을 첨부해주십시오*" disabled>
						    <label for="teacherImg">파일찾기</label> 
						    <input type="file" name="teacherImg" id="teacherImg" onchange="fileCheck(this)" accept="image/gif,image/jpeg,image/png">
						</div>
						<br>
						<button type="button" class="btn"
						data-dismiss="modal">취소</button>
						<button type="submit" class="btn submit" id="btn_modify_teacher">등록하기</button>
					</form>
				</div>
			</div>
		</div>	
	</div>
	<%-- END --%>
	
	<%-- MODIFY SUBJECT JS --%>
	<script>
	// 교사 과목 select box
	$("#modifySubjectSelboxDirect").hide();
	
	$("#modifySubjectSelbox").change(function() {
		$("#modifySubjectSelboxDirect").val('');
		// 직접입력을 누를 때 나타남
		if ($("#modifySubjectSelbox").val() == "direct") {
			$("#modifySubjectSelboxDirect").show();
		} else {
			$("#modifySubjectSelboxDirect").hide();
		}
	});
	
	</script>
	<%-- END --%>
	
	<%-- MAIN --%>
	<section id="content">
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
									<img class="img-responsive" src="/resources/img/teacher/${tnf.value.savedFileName}" alt="" width="260" height="260">
									<h4>${tnf.value.teacherName}</h4>
									<span class="deg">${tnf.value.subject}</span>
									<br><br>
									<button class="modify-btn" data-toggle="modal" data-target="#modify-teacher">수정</button>
									<button class="delete-btn">삭제</button>
								</div>
							</div>
						</c:if>
					</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</section>
	<%-- END --%>
<jsp:include page="/WEB-INF/views/include/footer.jsp" />
</div>

<script>
$("#regTeacher").on('click', function(){
	// 첨부파일 유효성 검사 (첨부파일 필수)
});
</script>

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