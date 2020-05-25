<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.dao.User" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="user" class="com.entity.UTO" scope="page"/>
<jsp:setProperty name="user" property="userID"/>
<jsp:setProperty name="user" property="userPassword"/>
<!DOCTYPE html>
<html>
<head>
		<title>CBookNU</title>

</head>
<body>
	<%
		User dao = new User();
		int result = dao.login(user.getuserID(), user.getuserPassword());
		if(result==1){
			PrintWriter script=response.getWriter();
			script.println("<script>");
			script.println("alert('접속완료 !')");
			script.println("location.href='main.jsp'");
			script.println("</script>");
		}
		else if(result==0){
			PrintWriter script=response.getWriter();
			script.println("<script>");
			script.println("alert('비밀번호가 틀립니다.')");
			script.println("history.back()");
			script.println("</script>");
		}
		else if(result==-1){
			PrintWriter script=response.getWriter();
			script.println("<script>");
			script.println("alert('존재하지 않는 아이디입니다.')");
			script.println("history.back()");
			script.println("</script>");
		}		
		else if(result==-2){
			PrintWriter script=response.getWriter();
			script.println("<script>");
			script.println("alert('데이터베이스 오류가 발생했습니다.')");
			script.println("history.back()");
			script.println("</script>");
		}
	%>
	<%System.out.println(user.getuserID()); %>
	<%session.setAttribute("ID", user.getuserID());%>
</body>
</html>