package com.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.User;
public class JoinRegisterCommand implements JoinCommand {

	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
				String userID = request.getParameter( "userID" );
				String userPassword = request.getParameter( "userPassword" );
				String userName = request.getParameter( "userName" );
				String userTell = request.getParameter( "userTell" );
				User dao = new User();
				if(!dao.checkID(userID)) {
					response.setContentType("text/html; charset=UTF-8");
		            PrintWriter out = response.getWriter();
		            out.println("<script>alert('아이디 중복!!'); location.href='join.jsp';</script>");
		            out.flush();
					return false;
				}
				dao.Register(userID, userPassword, userName, userTell);
				System.out.println(request.getParameter( "userID" ));
				return true;
	}
}
