<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
</head>
<body>
	<%-- HEADER --%>
	<header>
		<div class="navbar navbar-default navbar-static-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="home">
						<img src="/resources/styles/img/logo.png" alt="logo" />
					</a>
				</div>
				<div class="navbar-collapse collapse ">
					<ul class="nav navbar-nav">
						<li class="active"><a href="home">Home</a></li>
						<li class="dropdown" onmouseover="showDropdownAbout()" onmouseout="hideDropdownAbout()">
							<a href="about" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">학교소개<span class="caret"></span></a>
							<ul class="dropdown-menu" id="dropdown-about">
								<li><a href="about">교직원 인사말</a></li>
								<li><a href="">교육 목표</a></li>
								<li><a href="">학교연혁</a></li>
								<li><a href="">학교상징</a></li>
								<li><a href="">학교교가</a></li>
								<li><a href="">학교교육계획</a></li>
							</ul>
						</li>
						<li class="dropdown" onmouseover="showDropdownNews()" onmouseout="hideDropdownNews()">
							<a href="news" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">학교소식<span class="caret"></span></a>
							<ul class="dropdown-menu" id="dropdown-news">
								<li><a href="news">1</a></li>
								<li><a href="#">1</a></li>
								<li><a href="#">1</a></li>
							</ul>
						</li>
						<li><a href="portfolio">교사마당</a></li>
						<li><a href="pricing">학부모마당</a></li>
						<li><a href="pricing">학생마당</a></li>
						<li><a href="contact">문의</a></li>
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
		
		
	</script>
	<%-- END OF HEADER JS --%>
</body>
</html>