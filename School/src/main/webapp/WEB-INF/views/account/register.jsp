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

<jsp:include page="/WEB-INF/views/module/common-css.jsp" />
<link href="/resources/styles/css/custom/register.css" rel="stylesheet" />

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

</head>
<body>
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
				<form action="register" method="post">
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
								<label for="userName">이름</label>
							</div>
							<div class="information-right">
								<input type="text" class="userName" name="userName" id="userName" placeholder="실명 정확히 기재" minlength="2">
							</div>
						</div>
						<div class="information-except">
							<div class="information-left">
								<label for="userId">아이디</label>
							</div>
							<div class="information-right">
								<input type="text" class="userId" name="userId" id="userId" placeholder="최소 4자리 (영어숫자조합)" minlength="4">
								<button type="button" class="checkId-btn">중복확인</button>
							</div>
						</div>
						<div class="information-except">
							<div class="information-left">
							</div>
							<div class="information-right">
								<input type="text" class="checkIdResult" name="checkIdResult" id="checkIdResult" readonly>
							</div>
						</div>
						<div class="information-except">
							<div class="information-left">
								<label for="passwd">비밀번호</label>
							</div>
							<div class="information-right">
								<input type="password" class="passwd" name="passwd" id="passwd" placeholder="최소 4자리" minlength="4">
							</div>
						</div>
						<div class="information-except">
							<div class="information-left">
								<label for="checkPasswd">비밀번호 확인</label>
							</div>
							<div class="information-right">
								<input type="password" class="checkPasswd" name="checkPasswd" id="checkPasswd" placeholder="최소 4자리" minlength="4">
							</div>
						</div>
						<div class="information-except">
							<div class="information-left">
							</div>
							<div class="information-right">
								<input type="text" class="passwdSameCheck" name="passwdSameCheck" id="passwdSameCheck" readonly>
							</div>
						</div>
						<div class="information-except2">
							<div class="information-left">
								<label for="address">주소</label>
							</div>
							<div class="information-right-except">
								<input type="text" name="postCode" class="hide-cursor" id="sample6_postcode" placeholder="우편번호" style="width:100px;" readonly>
								<input type="hidden" name="address" id="address">
								<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
								<input type="text" class="hide-cursor" id="sample6_address" readonly><br>
								<input type="text" id="sample6_detailAddress" placeholder="상세주소"><br>
								<input type="text" class="hide-cursor" id="sample6_extraAddress" readonly>
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
					<button type="submit" class="register-btn">가입하기</button>
				</form>
			</div>
		</div>
	</div>
</div>

<%-----------------------------------------------------------------------------------------------------------------------------------------------------%-->

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
	
	// 아이디 중복 확인 (ajax 비동기 방식)
	$('.checkId-btn').on('click', function(event) {
		
		const userId = $('input[name=userId]').val();

		// 아무것도 입력하지 않았을 경우 + 4자리 미만 입력시
		if (userId.length < 4) {
			$('input[name=checkIdResult]').val("4자리 이상 입력해주십시오");
			$('input[name=checkIdResult]').css({
				'color': 'red'
			});
			return false;
		}
		
		// 영어, 숫자 외에 입력했을 경우
		var regType = /^[A-Za-z0-9]*$/;
		if (!regType.test(userId)) {
			$('input[name=checkIdResult]').val("영문, 숫자만 가능합니다");
			$('input[name=checkIdResult]').css({
				'color': 'red'
			});
			return false;
		}
		
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
						'color': 'blue'
					});
				}
			},
			"error":function(xhr, status, err){
				alert("오류");
			}
		});
	});
	
	// 유효성 검사
	$('.register-btn').on('click', function(event) {

		var userId = document.getElementById("userId");
		var checkIdResult = document.getElementById("checkIdResult");
		var passwd = document.getElementById("passwd");
		var checkPasswd = document.getElementById("checkPasswd");
		var passwdSameCheck = document.getElementById("passwdSameCheck");
		var postCode = document.getElementById("sample6_postcode");
		var address1 = document.getElementById("sample6_address");
		var address2 = document.getElementById("sample6_detailAddress");
		var address3 = document.getElementById("sample6_extraAddress");
		var phone1 = document.getElementById("phone1");
		var phone2 = document.getElementById("phone2");
		var phone3 = document.getElementById("phone3");
		
		// 입력창이 비어있거나 제대로 입력되지 않은 경우
		if(!userId.value) {
			alert("아이디를 입력하세요")
			userId.focus();
			return false;
		}
		if(!checkIdResult.value) {
			alert("중복확인을 하세요")
			return false;
		}
		if(checkIdResult.value != "사용 가능한 아이디입니다") {
			alert("아이디를 확인해주세요")
			userId.focus();
			return false;
		}
		if(!passwd.value) {
			alert("비밀번호를 입력하세요")
			passwd.focus();
			return false;
		}
		if(!checkPasswd.value) {
			alert("비밀번호 확인을 입력하세요")
			checkPasswd.focus();
			return false;
		}
		if(passwdSameCheck.value == "일치하지 않습니다") {
			alert("비밀번호가 일치하지 않습니다");
			return false;
		}
		if(!postCode.value) {
			alert("주소를 선택하세요")
			return false;
		}
		if(!address2.value) {
			alert("상세주소를 입력하세요")
			address2.focus();
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
		
		// 중복확인 결과 이미 존재하는 아이디인데 가입 누른 경우
		if (checkIdResult.value == "이미 존재하는 아이디입니다") {
			alert("사용할 수 없는 아이디입니다")
			return false;
		}
		
		// 비밀번호 확인 결과 일치하지 않는데 가입 누른 경우
		if (passwdSameCheck.value == "일치하지 않습니다") {
			alert("비밀번호가 일치하지 않습니다");
			checkPasswd.focus();
			return false;
		}

		$('input[name=address]').val(address1.value + " " + address2.value + address3.value);
			
		return document.register.submit();
	});
	
	// input[name=userId] 변화 감지 유효성 검사 (onchange)
	$('.userId').on('change', function(event) {
		
		$('input[name=checkIdResult]').val("중복확인을 해주세요");
		$('input[name=checkIdResult]').css({
			'color': 'red'
		});
		
	});
	
	// 비밀번호 일치 확인 + 유효성 검사 (onchange)
	$('.checkPasswd').on('change', function(event) {
		
		var passwd = document.getElementById("passwd").value;
		var checkPasswd = document.getElementById("checkPasswd").value;
		
		if (passwd != '' && checkPasswd != '') {
			// 비밀번호 일치 확인
			if (passwd == checkPasswd) {
				$('input[name=passwdSameCheck]').val("일치합니다");
				$('input[name=passwdSameCheck]').css({
					'color': 'blue'
				});
			}
			else {
				$('input[name=passwdSameCheck]').val("일치하지 않습니다");
				$('input[name=passwdSameCheck]').css({
					'color': 'red'
				});
			}
			// 4자리 미만 입력시
			if (passwd.length < 4 || checkPasswd < 4) {
				$('input[name=passwdSameCheck]').val("4자리 이상 입력해주십시오");
				$('input[name=passwdSameCheck]').css({
					'color': 'red'
				});
			}
		}
	});
	
});
</script>

<%-- KAKAO 주소 API --%>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("sample6_extraAddress").value = extraAddr;
            
            } else {
                document.getElementById("sample6_extraAddress").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample6_postcode').value = data.zonecode;
            document.getElementById("sample6_address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("sample6_detailAddress").focus();
        }
    }).open();
}
</script>
<%-- JS END --%>

</body>
</html>








