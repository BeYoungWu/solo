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
				<c:choose>
				<c:when test="${ loginuser.userType eq 4 }">
				<div class="login_after">
					<ul>
						<li>
						<a href="/admin">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-gear" viewBox="0 0 16 16">
							<path d="M8 4.754a3.246 3.246 0 1 0 0 6.492 3.246 3.246 0 0 0 0-6.492zM5.754 8a2.246 2.246 0 1 1 4.492 0 2.246 2.246 0 0 1-4.492 0z"/>
							<path d="M9.796 1.343c-.527-1.79-3.065-1.79-3.592 0l-.094.319a.873.873 0 0 1-1.255.52l-.292-.16c-1.64-.892-3.433.902-2.54 2.541l.159.292a.873.873 0 0 1-.52 1.255l-.319.094c-1.79.527-1.79 3.065 0 3.592l.319.094a.873.873 0 0 1 .52 1.255l-.16.292c-.892 1.64.901 3.434 2.541 2.54l.292-.159a.873.873 0 0 1 1.255.52l.094.319c.527 1.79 3.065 1.79 3.592 0l.094-.319a.873.873 0 0 1 1.255-.52l.292.16c1.64.893 3.434-.902 2.54-2.541l-.159-.292a.873.873 0 0 1 .52-1.255l.319-.094c1.79-.527 1.79-3.065 0-3.592l-.319-.094a.873.873 0 0 1-.52-1.255l.16-.292c.893-1.64-.902-3.433-2.541-2.54l-.292.159a.873.873 0 0 1-1.255-.52l-.094-.319zm-2.633.283c.246-.835 1.428-.835 1.674 0l.094.319a1.873 1.873 0 0 0 2.693 1.115l.291-.16c.764-.415 1.6.42 1.184 1.185l-.159.292a1.873 1.873 0 0 0 1.116 2.692l.318.094c.835.246.835 1.428 0 1.674l-.319.094a1.873 1.873 0 0 0-1.115 2.693l.16.291c.415.764-.42 1.6-1.185 1.184l-.291-.159a1.873 1.873 0 0 0-2.693 1.116l-.094.318c-.246.835-1.428.835-1.674 0l-.094-.319a1.873 1.873 0 0 0-2.692-1.115l-.292.16c-.764.415-1.6-.42-1.184-1.185l.159-.291A1.873 1.873 0 0 0 1.945 8.93l-.319-.094c-.835-.246-.835-1.428 0-1.674l.319-.094A1.873 1.873 0 0 0 3.06 4.377l-.16-.292c-.415-.764.42-1.6 1.185-1.184l.292.159a1.873 1.873 0 0 0 2.692-1.115l.094-.319z"/>
							</svg>
						</a></li>
						<li><a href="/account/logout">로그아웃</a></li>
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
								<li><a href="/about/purpose">교육목표</a></li>
								<li><a href="/about/history">학교연혁</a></li>
								<li><a href="/about/current">학교현황</a></li>
								<li><a href="/about/symbol">학교상징</a></li>
								<li><a href="/about/song">학교교가</a></li>
								<li><a href="/list?boardType=0">학교교육계획</a></li>
							</ul>
						</li>
						<li class="dropdown" onmouseover="showDropdownNews()" onmouseout="hideDropdownNews()">
							<a href="/board/list?boardType=1">알림마당</a>
							<ul class="dropdown-menu" id="dropdown-news">
								<li><a href="/board/list?boardType=1">공지사항</a></li>
								<li><a href="/board/list?boardType=2">가정통신문</a></li>
								<li><a href="news/schedule">학교일정</a></li>
								<li><a href="/board/list?boardType=3">학교행사</a></li>
								<li><a href="/board/list?boardType=4">급식표</a></li>
								<li><a href="/board/list?boardType=5">교육복지특별지원사업</a></li>
							</ul>
						</li>
						<li>
							<a href="/board/list?boardType=6">교사마당</a>
						</li>
						<li class="dropdown" onmouseover="showDropdownParent()" onmouseout="hideDropdownParent()">
							<a href="/board/list?boardType=7">학부모마당</a>
							<ul class="dropdown-menu" id="dropdown-parent">
								<li><a href="/board/list?boardType=7">학부모회</a>
								<li><a href="/board/list?boardType=8">자료실</a></li>
							</ul>
						</li>
						<li class="dropdown" onmouseover="showDropdownStudent()" onmouseout="hideDropdownStudent()">
							<a href="/board/list?boardType=9">학생마당</a>
							<ul class="dropdown-menu" id="dropdown-student">
								<li><a href="/board/list?boardType=9">학생회</a></li>
								<li><a href="/board/list?boardType=10">과목별학습자료실</a></li>
								<li><a href="/board/list?boardType=11">방과후학교</a></li>
								<li><a href="/board/list?boardType=12">도서실</a></li>
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
