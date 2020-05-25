<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.dao.User"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>CBookNU-회원가입</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<style>
		fieldset{
			width:450px;	
			margin:auto;
			color:black;
			border-color:gray;
		}
		legend{
			text-align:center;
			font-size:15px;
			font-weight:bold;
		}
		.input{
			display:inline;
		}
		div.btn{
			margin:auto;
			width:5%;
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
								<header id="header">
									<p class="logo" style="text-align:center"><strong>CBookNU</strong></p>
								</header>
							<br>
							<br>
							<br>
							
							<!--fieldset-->
							
							<div class="center">
							<form action="join.do" method="post">
									<legend>입력 항목</legend>
										<p>이름 <input  type="text" name="userName" placeholder="여백없이 입력하세요" required></p>
										<p>연락처 <input  type="text" name="userTell" placeholder="- 빼고 숫자만 입력하세요" required></p>
									
										<p>아이디 <input  type="text" name="userID" placeholder="10자 이내의 영어 대,소문자, 숫자만 입력하세요." required></p>
										
										<p>비밀번호 <input  type="password" name="userPassword" placeholder="10자 이내의 영어 대,소문자, 숫자만 입력하세요." required>
							<br>
							<br>	
										<input type="submit" value="가입하기"  class="button big" >			
							</form>
							</div>
							
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