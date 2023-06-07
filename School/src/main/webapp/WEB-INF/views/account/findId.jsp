<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="" />
<meta name="author" content="http://webthemez.com" />

<jsp:include page="/WEB-INF/views/module/common-css.jsp" />
<link href="/resources/styles/css/custom/findId.css" rel="stylesheet" />

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

</head>
<body>
<div id="wrapper">
<jsp:include page="/WEB-INF/views/include/header.jsp" />
	<section id="inner-headline">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<h2 class="pageTitle">아이디 찾기</h2>
				</div>
			</div>
		</div>
	</section>
	<div class="container text-center">
		<div class="row">
			<div class="col-lg-12">
				<form action="findId" method="post">
				<div class="informations">
					<div class="information">
						<div class="information-left">
							<label for="userName">이름</label>
						</div>
						<div class="information-right">
							<input type="text" name="userName" id="userName">
						</div>
					</div>
					<div class="information">
						<div class="information-left">
							<label for="phone1">전화번호</label>
						</div>
						<div class="information-right">
							<input type="hidden" name="phone">
							<select name="phone1" class="form-select" aria-label="Default select example" style="width:80px">
								<option selected value="010">010</option>
								<option value="011">011</option>
								<option value="012">012</option>
								<option value="013">013</option>
								<option value="014">014</option>
								<option value="015">015</option>
								<option value="016">016</option>
								<option value="017">017</option>
								<option value="018">018</option>
								<option value="019">019</option>
							</select>
							&nbsp;&nbsp;
							<input type="number" name="phone2" id="phone2" maxlength="4" oninput="maxLengthCheck(this)">
							&nbsp;&nbsp;
							<input type="number" name="phone3" id="phone3" maxlength="4" oninput="maxLengthCheck(this)">
						</div>
					</div>
				</div>
				<button type="submit" class="find-btn" data-toggle="modal" data-target="#findIdResult">아이디 찾기</button>
				</form>
			</div>
		</div>
	</div>
	
	<%-- FIND ID RESULT MODAL --%>
	<div class="modal fade" id="findIdResult" tabindex="-1" role="dialog"
		aria-labelledby="exampleMdalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel" style="color: #000;">아이디 찾기 결과</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body" style="text-align:center">
				
				</div>
			</div>
		</div>	
	</div>
	<%-- END --%>
</div>

<%-- JS --%>
<script>
//input type number maxlength (전화번호 4자리)
function maxLengthCheck(object) {
	if (object.value.length > object.maxLength) {
		// object.maxLength : 매개변수 오브젝트의 maxLength 속성 값
		object.value = object.value.slice(0, object.maxLength);
	}
}
</script>

<script type="text/javascript">
$(function() {
	// 유효성 검사
	$('.find-btn').on('click', function(event) {

		var userName = document.getElementById("userName");
		var userNameVal = $('input[name=userName]').val()
		var phone1 = document.getElementById("phone1");
		var phone2 = document.getElementById("phone2");
		var phone3 = document.getElementById("phone3");
	
		// 아무것도 입력하지 않았을 경우 + 2자리 미만 입력시
		if (userNameVal.length < 2) {
			alert("이름을 입력하세요");
			userName.focus();
			return false;
		}
		
		// 입력창이 비어있거나 제대로 입력되지 않은 경우
		if(!userName.value) {
			alert("이름을 입력하세요");
			userName.focus();
			return false;
		}
		if(!phone2.value || phone2.value.length < 4) {
			alert("전화번호를 입력하세요")
			phone2.focus();
			return false;
		}
		if(!phone3.value || phone3.value.length < 4) {
			alert("전화번호를 입력하세요")
			phone3.focus();
			return false;
		}
			
		return document.findId.submit();
	});	
});
</script>
<%-- JS END --%>

</body>
</html>