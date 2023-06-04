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
							<h7>
							${ loginuser.userId }
							(${ loginuser.userName })
							님
							</h7>
						</li>
						<li>
							<a href="/home">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-house" viewBox="0 0 16 16">
							<path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L2 8.207V13.5A1.5 1.5 0 0 0 3.5 15h9a1.5 1.5 0 0 0 1.5-1.5V8.207l.646.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.707 1.5ZM13 7.207V13.5a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5V7.207l5-5 5 5Z"/>
							</svg>
							</a>
						</li>
						<li><a href="/account/logout">로그아웃</a></li>
					</ul>
				</div>
				</c:when>
				<c:otherwise>
				<div class="login_after">
					<ul>
						<li>
							<h7>
							${ loginuser.userId }
							(${ loginuser.userName })
							님
							</h7>
						</li>
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
					<a class="navbar-brand" href="/admin">
						<img src="/resources/styles/img/logo.png" alt="logo" />
					</a>
				</div>
				<div class="navbar-collapse collapse ">
					<ul class="nav navbar-nav">
						<li class=""><a href="/admin">Home</a></li>
						<li class="dropdown" onmouseover="showDropdownAbout()" onmouseout="hideDropdownAbout()">
							<a href="/admin/aboutAdmin">학교소개</a>
							<ul class="dropdown-menu" id="dropdown-about">
								<li><a href="/admin/aboutAdmin">교직원소개</a></li>
								<li><a href="/admin/purposeAdmin">교육목표</a></li>
								<li><a href="/admin/historyAdmin">학교연혁</a></li>
								<li><a href="/admin/currentAdmin">학교현황</a></li>
								<li><a href="/admin/symbolAdmin">학교상징</a></li>
								<li><a href="/admin/songAdmin">학교교가</a></li>
								<li><a href="/admin/board/list?boardType=0">학교교육계획</a></li>
							</ul>
						</li>
						<li class="dropdown" onmouseover="showDropdownNews()" onmouseout="hideDropdownNews()">
							<a href="/admin/board/list?boardType=1">알림마당</a>
							<ul class="dropdown-menu" id="dropdown-news">
								<li><a href="/admin/board/list?boardType=1">공지사항</a></li>
								<li><a href="/admin/board/list?boardType=2">가정통신문</a></li>
								<li><a href="/admin/scheduleAdmin">학교일정</a></li>
								<li><a href="/admin/board/list?boardType=3">학교행사</a></li>
								<li><a href="/admin/board/list?boardType=4">급식표</a></li>
								<li><a href="/admin/board/list?boardType=5">교육복지특별지원사업</a></li>
							</ul>
						</li>
						<li>
							<a href="/admin/board/list?boardType=6">교사마당</a>
						</li>
						<li class="dropdown" onmouseover="showDropdownParent()" onmouseout="hideDropdownParent()">
							<a href="/admin/board/list?boardType=7">학부모마당</a>
							<ul class="dropdown-menu" id="dropdown-parent">
								<li><a href="/admin/board/list?boardType=7">학부모회</a>
								<li><a href="/admin/board/list?boardType=8">자료실</a></li>
							</ul> 
						</li>
						<li class="dropdown" onmouseover="showDropdownStudent()" onmouseout="hideDropdownStudent()">
							<a href="/admin/board/list?boardType=9">학생마당</a>
							<ul class="dropdown-menu" id="dropdown-student">
								<li><a href="/admin/board/list?boardType=9">학생회</a></li>
								<li><a href="/admin/board/list?boardType=10">과목별학습자료실</a></li>
								<li><a href="/admin/board/list?boardType=11">방과후학교</a></li>
								<li><a href="/admin/board/list?boardType=12">도서실</a></li>
							</ul>
						</li>
						<li>
							<a href="/admin/contactAdmin">문의</a>
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
