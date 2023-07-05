<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
				<form>
				<c:choose>
				<c:when test="">
				<div class="result">
				<table>
					<c:forEach var="account" items="${ accounts }">
					<tr>
						<td>아이디</td>
						<td>${ account.userId }</td>
					</tr>
					</c:forEach>
				</table>
				</div>
				<button type="submit" class="find-btn" data-toggle="modal" data-target="#findIdResult">아이디 찾기</button>
				</c:when>
				<c:otherwise>
				조회 결과가 없습니다
				<button type="submit" class="">돌아가기</button>
				</c:otherwise>
				</c:choose>
				</form>
			</div>
		</div>
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
			alert("이름을 다시 입력하세요");
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