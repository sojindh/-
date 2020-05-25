<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>CBNU-book_sale</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<style>
			.sel {
				margin-top: 8px;
			}
			
			#num {
				width : 50px;
			}
			
			#major {
				width : 100px;
			}
			
			#title {
				width : 700px;
			}
			
			#publisher {
				width : 80px;
			}
			
			#price {
				width : 50px;
			}
			
			#author {
				width : 80px;
			}
			
			#writeday {
				width : 70px;
			}
		</style>
	</head>
	<body>

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<div id="main">
						<div class="inner">

							<!-- Header -->
								<div class="header" id="header">
									<p class="logo"><strong>Second-hand Books Sale</strong></p>
										
								</div>

							<!-- Banner -->
								<div class="section" id="banner" style="display:block">
									 <form  action="book_sale_search.do" >
										<select name="searchName" size="1">
											<option value="userID">작성자</option>
											<option value="title">제목</option>
 							          	</select>
										<input type="text" name="searchValue" >
										<input type="submit" value="찾기">
 							        </form>
									<table>
										<tr>
											<th id="userID">작성자</th>
											<th id="major">전공</th>
											<th id="title">제목</th>
											<th id="publisher">출판사</th>
											<th id="price">가격</th>
											<th id="author">저자</th>
											<th id="writeday">날짜</th>
										</tr>
										<c:forEach items="${list}" var="dto">
 									  	<tr>
											<td>${dto.userID}</td>
											<td>${dto.major}</td>
											<td><a href="book_sale_retrieve.do?num=${dto.num}">${dto.title}</a></td>
											<td>${dto.publisher}</td>
											<td>${dto.price}</td>
											<td>${dto.author}</td>
											<td>${dto.writeday}</td>
										</tr>

										</c:forEach>	
										
										</tfoot>

									</table>
									<a href="book_sale_writeui.do">글쓰기</a>
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
										<li><a href="main.jsp">main</a></li>
										<li><a href="info.jsp">info</a></li>
										<li>
											<span class="opener">Report</span>
											<ul>
												<li><a href="report_sale.do">Sale</a></li>
											</ul>
										</li>
										<li>
											<span class="opener">Second-hand books</span>
											<ul>
												<li><a href="book_sale.do">Sale</a></li>
											</ul>
										</li>
										<li><a href="free_board.do">free board</a></li>
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