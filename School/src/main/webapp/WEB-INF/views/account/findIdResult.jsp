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
				<c:when test="${ not empty accounts }">
				<div class="result">
				<table class="table">
					<c:forEach var="account" items="${ accounts }">
					<tr>
						<td>이름: [ ${ account.userName } ] / 아이디: [ ${ account.userId } ]</td>
					</tr>
					</c:forEach>
				</table>
				</div>
				<button type="button" onclick="location.href='findPasswd'">비밀번호 찾기</button>
				</c:when>
				<c:otherwise>
				<div class="none">
				조회 결과가 없습니다
				</div>
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
<%-- JS END --%>

</body>
</html>