<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>CBookNU</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		
		<script>
			function GoSineIn(){
				alert("로그인 후 이용가능합니다.");
				window.location.replace("signIn.jsp");
			}
	</script>
	
	</head>
	<body>

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<div id="main">
						<div class="inner">

							<!-- Header -->
								<header id="header">
									<a href="index.jsp" class="logo"><strong>Chungbuk national university</strong></a>
										
								</header>

							<!-- Banner -->
								<section id="banner">
									<div class="content">
										<header>
											<h1>CBookNU</h1>
											<p>A website that sells Second-hand books and Reports</p>
										</header>
										<p>CBookNU는 충북대학교 학생들이 자유롭게 중고서적과 레포트를 판매, 구매 할 수 있는 사이트 입니다.</p>
										<ul class="actions">
											<li style="display:inline"><a href="signIn.jsp" class="button big">SIGN IN</a></li>
											<li style="display:inline"><a href="signUp.jsp" class="button big">SIGN UP</a></li>
										</ul>
									</div>
									<span class="image object">
										<img src="images/pic10.jpg" alt="" />
									</span>
								</section>

					

						</div>
					</div>

				<!-- Sidebar -->
					<div id="sidebar">
						<div class="inner">

							<!-- Search -->
								<section id="search" class="alt">
									<form method="post" action="#">
										<input type="text" name="query" id="query" placeholder="Search" />
									</form>
								</section>

							<!-- Menu -->
								<nav id="menu">
									<header class="major">
										<h2>Menu</h2>
									</header>
									<ul>
										<li>main</li>
										<li><a href="info.jsp">info</a></li>
										<li>
											<span class="opener">Report</span>
											<ul>
												<li onclick="GoSineIn()"><a href="report_sale.do">Sale</a></li>
												<li onclick="GoSineIn()"><a href="report_purchase.jsp">Purchase</a></li>
											</ul>
										</li>
										<li>
											<span class="opener">Second-hand books</span>
											<ul>
												<li onclick="GoSineIn()"><a href="book_sale.jsp">Sale</a></li>
												<li onclick="GoSineIn()"><a href="book_sale.do">Purchase</a></li>
											</ul>
										</li>
										<li onclick="GoSineIn()"><a href="freeboard.do">free board</a></li>
									</ul>
								</nav>

				

							<!-- Section -->
								<section>
									<header class="major">
										<h2>Representative</h2>
									</header>
									<p>Park Kyung Min</p>
									<ul class="contact">
										<li class="fa-envelope-o"><a href="#">information@untitled.tld</a></li>
										<li class="fa-phone">(010) 1234-5678</li>
										<li class="fa-home">1234 Somewhere Road #8254<br />
										Nashville, TN 00000-0000</li>
									</ul>
								</section>

							<!-- Footer -->
								<footer id="footer">
									<p class="copyright">&copy; Untitled. All rights reserved. Demo Images: <a href="https://unsplash.com">Unsplash</a>. Design: <a href="https://html5up.net">HTML5 UP</a>.</p>
								</footer>

						</div>
					</div>

			</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>

	</body>
</html>