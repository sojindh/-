<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
		<title>CBookNU</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<style>
			.input{
				display:inline;
			}
			div.btn{
				margin:auto;
				width:19%;
			}
			div.center{
				margin:auto;
				width:30%;
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
						<nav id="header">
							<p class="logo" style="text-align:center"><strong>CBookNU</strong></p>
						</nav>
						<br>
						<br>
						<br>
						<div class="center">
							<form  action="loginAction.jsp" method="post">
								<h3 style="text-align:center">로그인</h3>
									아이디 <input type="text" name="userID">
									비밀번호 <input type="password" name="userPassword">
							<br>
							<br>
							<br>	
							<div class="btn">
								<input type="submit" class="button big" value="로그인">
							</div>
							</form>
						</div>	
						</div>
					</div>
				</div>

	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/skel.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>
</body>
</html>