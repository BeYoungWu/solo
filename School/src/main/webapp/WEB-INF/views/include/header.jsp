<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
	
	<%-- HEADER --%>
	<header>
		<div class="login-navbar">
			<c:choose>
			<c:when test="${ empty loginuser }">
			<div class="login_before">
				<ul>
					<li><a href="/account/login">로그인</a></li>
					<li><a href="/account/register">회원가입</a></li>
				</ul>
			</div>
			</c:when>
			<c:otherwise>
			<div class="login_after">
				<ul>
					<li><a href="/account/logout">로그아웃</a></li>
				</ul>
			</div>
			</c:otherwise>
			</c:choose>
			</div>
		<div class="navbar navbar-default navbar-static-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="/home">
						<img src="/resources/styles/img/logo.png" alt="logo" />
					</a>
				</div>
				<div class="navbar-collapse collapse ">
					<ul class="nav navbar-nav">
						<li class="active"><a href="/home">Home</a></li>
						<li class="dropdown" onmouseover="showDropdownAbout()" onmouseout="hideDropdownAbout()">
							<a href="/about">학교소개</a>
							<ul class="dropdown-menu" id="dropdown-about">
								<li><a href="/about">교직원소개</a></li>
								<li><a href="/purpose">교육목표</a></li>
								<li><a href="/history">학교연혁</a></li>
								<li><a href="/current">학교현황</a></li>
								<li><a href="/symbol">학교상징</a></li>
								<li><a href="/song">학교교가</a></li>
								<li><a href="/plan">학교교육계획</a></li>
							</ul>
						</li>
						<li class="dropdown" onmouseover="showDropdownNews()" onmouseout="hideDropdownNews()">
							<a href="/news">알림마당</a>
							<ul class="dropdown-menu" id="dropdown-news">
								<li><a href="/news">공지사항</a></li>
								<li><a href="#">가정통신문</a></li>
								<li><a href="#">학교일정</a></li>
								<li><a href="#">학교행사</a></li>
								<li><a href="#">급식표</a></li>
								<li><a href="#">교육복지특별지원사업</a></li>
							</ul>
						</li>
						<li>
							<a href="/teacherBoard">교사마당</a>
						</li>
						<li class="dropdown" onmouseover="showDropdownParent()" onmouseout="hideDropdownParent()">
							<a href="/parentBoard">학부모마당</a>
							<ul class="dropdown-menu" id="dropdown-parent">
								<li><a href="/parentBoard">학부모회</a>
								<li><a href="#">자료실</a></li>
							</ul>
						</li>
						<li class="dropdown" onmouseover="showDropdownStudent()" onmouseout="hideDropdownStudent()">
							<a href="/studentBoard">학생마당</a>
							<ul class="dropdown-menu" id="dropdown-student">
								<li><a href="/studentBoard">학생회</a></li>
								<li><a href="#">과목별학습자료실</a></li>
								<li><a href="#">방과후학교</a></li>
								<li><a href="#">도서실</a></li>
							</ul>
						</li>
						<li>
							<a href="/contact">문의</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</header>
	<%-- END OF HEADER --%>
	<%-- HEADER JS --%>
	<script type="text/javascript">
		// About Dropdown
		function showDropdownAbout() {
			document.getElementById("dropdown-about").style.display = "block";
		}

		function hideDropdownAbout() {
			document.getElementById("dropdown-about").style.display = "none";
		}
		
		// News Dropdown
		function showDropdownNews() {
			document.getElementById("dropdown-news").style.display = "block";
		}

		function hideDropdownNews() {
			document.getElementById("dropdown-news").style.display = "none";
		}
		
		// ParentBoard Dropdown
		function showDropdownParent() {
			document.getElementById("dropdown-parent").style.display = "block";
		}

		function hideDropdownParent() {
			document.getElementById("dropdown-parent").style.display = "none";
		}
		
		// StudentBoard Dropdown
		function showDropdownStudent() {
			document.getElementById("dropdown-student").style.display = "block";
		}

		function hideDropdownStudent() {
			document.getElementById("dropdown-student").style.display = "none";
		}
		
	</script>
	<%-- END OF HEADER JS --%>
