<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>CBookNU- 회원가입</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<style>
			div.btn{
				margin:auto;
				width:20%;
			}
		</style>
		<script>
			function checkform(Join){
			var chk1=document.join.agree1.checked;
			var chk2=document.join.agree2.checked;
				if(!chk1){
					alert("회원가입약관의 내용에 동의하셔야 회원가입 하실 수 있습니다.");
					return false;
				}
				if (!chk2) {
					alert("개인정보처리방침안내의 내용에 동의하셔야 회원가입 하실 수 있습니다.");
					return false;
				}
				return true;
			}
			function next(x){
				if(x)
					window.location.replace("join.jsp");
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
									<p class="logo"><strong>Sign Up</strong></p>
										
								</header>

							<!-- 약관 -->
							<div>
								<br>
								<form name="join" action="join.jsp" onsubmit="next(checkform(this))">
									<p>회원가입약관 및 개인정보처리방침안내의 내용에 동의하셔야 회원가입 하실 수 있습니다.</p>
									<h4 style="text-decoration:underline"><strong>회원가입약관</strong></h4>
									<iframe src="terms.jsp" width="100%"></iframe>
									<label>회원가입약관의 내용에 동의합니다.<input type="checkbox" name="agree1" id="agree1" value=""></label>
									<br>
									<br>
									<br>
									<h4 style="text-decoration:underline"><strong>개인정보처리방침안내</strong></h4>
									<iframe src="terms2.jsp" width="100%"></iframe>
									<label>개인정보처리방침안내의 내용에 동의합니다.<input type="checkbox" name="agree2" value="" id="agree2"></label>
									<br>
									<br>
									<div class="btn">
									<ul class="actions">
										<li><input type="submit" class="button big" value="회원가입"/></li>
									</ul>
									</div>
								</form>										
								</div>		
							</div>
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
										<li><a href="index.jsp">main</a></li>
										<li><a href="info.jsp">info</a></li>
										<li>
											<span class="opener">Report</span>
											<ul>
												<li><a href="report_sale.jsp">Sale</a></li>
												<li><a href="report_purchase.jsp">Purchase</a></li>
											</ul>
										</li>
										<li>
											<span class="opener">Second-hand books</span>
											<ul>
												<li><a href="book_sale.jsp">Sale</a></li>
												<li><a href="book_purchase.jsp">Purchase</a></li>
											</ul>
										</li>
										<li><a href="freeboard.jsp">free board</a></li>
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

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>

	</body>
</html>