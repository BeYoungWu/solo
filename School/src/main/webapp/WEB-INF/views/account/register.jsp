<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="" />
<meta name="author" content="http://webthemez.com" />
<!-- css -->
<link href="/resources/styles/css/bootstrap.min.css" rel="stylesheet" />
<link href="/resources/styles/css/fancybox/jquery.fancybox.css" rel="stylesheet">
<link href="/resources/styles/css/flexslider.css" rel="stylesheet" />
<link href="/resources/styles/css/style.css" rel="stylesheet" />
<link href="/resources/styles/css/custom/header.css" rel="stylesheet" />
<link href="/resources/styles/css/custom/register.css" rel="stylesheet" />

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

</head>
<body>0
<div id="wrapper">
<jsp:include page="/WEB-INF/views/include/header.jsp" />
	<section id="inner-headline">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<h2 class="pageTitle">회원가입</h2>
				</div>
			</div>
		</div>
	</section>
	<div class="container text-center">
		<div class="row">
			<div class="col-lg-12">
				<form action="register" method="post" id="register">
					<div class="wantTypeRadio">
						<h3>회원유형</h3>
						<ol class="wantType">
							<li>
								<input type="radio" name="wantType" id="normal" value=0 checked>
								<label for="normal">일반</label>
							</li>
							<li>
								<input type="radio" name="wantType" id="student" value=1>
								<label for="student">학생</label>
							</li>
							<li>
								<input type="radio" name="wantType" id="parent" value=2>
								<label for="parent">학부모</label>
							</li>
							<li>
								<input type="radio" name="wantType" id="teacher" value=3>
								<label for="teacher">교직원</label>
							</li>
							<li>
								<input type="radio" name="wantType" id="administrator" value=4>
								<label for="administrator">관리자</label>
							</li>
						</ol>
					</div>
					<hr>
					<div class="informations">
						<h3>회원정보</h3>
						<div class="information-except">
							<div class="information-left">
								<label for="userId">아이디</label>
							</div>
							<div class="information-right">
								<input type="text" name="userId" id="userId" placeholder="최소 4자리 입력" minlength="4">
								<button type="button" class="checkId-btn">중복확인</button>
							</div>
						</div>
						<div class="information-except">
							<div class="information-left">
							</div>
							<div class="information-right">
								<input type="text" class="checkIdResult" name="checkIdResult" readonly>
							</div>
						</div>
						<div class="information">
							<div class="information-left">
								<label for="passwd">비밀번호</label>
							</div>
							<div class="information-right">
								<input type="password" name="passwd" id="passwd" placeholder="최소 4자리 입력" minlength="4">
							</div>
						</div>
						<div class="information">
							<div class="information-left">
								<label for="checkPasswd">비밀번호 확인</label>
							</div>
							<div class="information-right">
								<input type="password" name="checkPasswd" id="checkPasswd" placeholder="최소 4자리 입력" minlength="4">
							</div>
						</div>
						<div class="information">
							<div class="information-left">
								<label for="address">주소</label>
							</div>
							<div class="information-right">
								<input type="text" name="address" id="address" placeholder="주소API로 변경 예정">
							</div>
						</div>
						<div class="information">
							<div class="information-left">
								<label for="phone1">전화번호</label>
							</div>
							<div class="information-right">
								<select name="phone1" class="form-select" aria-label="Default select example" style="width: 80px">
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
								<input type="number" name="phone2" maxlength="4" oninput="maxLengthCheck(this)">
								&nbsp;&nbsp;
								<input type="number" name="phone3" maxlength="4" oninput="maxLengthCheck(this)">
							</div>
						</div>
						<div class="information">
						
						</div>
					</div>
					<button type="submit">가입하기</button>
				</form>
			</div>
		</div>
	</div>
</div>

<%-----------------------------------------------------------------------------------------------------------------------------------------------------%-->

<%-- JS --%>
<script type="text/javascript">
	$(function() {
		// input type number maxlength (전화번호 4자리)
		function maxLengthCheck(object) {
			if (object.value.length > object.maxLength) {
				// object.maxLength : 매개변수 오브젝트의 maxLength 속성 값
				object.value = object.value.slice(0, object.maxLength);
			}
		}
		
		// 아이디 중복 확인 (ajax 비동기 방식)
		$('.checkId-btn').on('click', function(event) {
			const userId = $('input[name=userId]').val();
			
			// ajax로 데이터 조회 -> 조회된 결과를 띄움
			$.ajax({
				"method":"POST",
				"url":"/account/checkId",
				"data": {userId: userId},
				"success":function(data, xhr, status ){
					if (data.userId != null) {
						$('input[name=checkIdResult]').val("이미 존재하는 아이디입니다");
						$('input[name=checkIdResult]').css({
							'color': 'red'
						});
					} else {
						$('input[name=checkIdResult]').val("사용 가능한 아이디입니다");
						$('input[name=checkIdResult]').css({
							'color': 'green'
						});
					}
				},
				"error":function(xhr, status, err){
					alert("오류");
				}
			});
		});
	});
</script>
<%-- JS END --%>

</body>
</html>








