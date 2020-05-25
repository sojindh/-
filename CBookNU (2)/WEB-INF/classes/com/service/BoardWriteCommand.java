package com.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BoardBP;
import com.dao.BoardFB;
import com.dao.BoardRP;

public class BoardWriteCommand implements BoardCommand {
	@Override
	public void executeBP(HttpServletRequest request, HttpServletResponse response) {
				String title = request.getParameter( "title" );
				String major = request.getParameter( "major" );
				String publisher = request.getParameter( "publisher" );
				String price = request.getParameter( "price" );
				String author = request.getParameter( "author" );
				String content = request.getParameter( "content" );
				String userID = request.getParameter("userID");
				BoardBP dao = new BoardBP();
				dao.write( title,  major, publisher, price, author , content, userID );
	}

	@Override
	public void executeFB(HttpServletRequest request, HttpServletResponse response) {
				String title = request.getParameter( "title" );
				String userID = request.getParameter( "userID" );
				String content = request.getParameter( "content" );
				BoardFB dao = new BoardFB();
				dao.write( title, userID , content);
	}
	
	public void executereport(HttpServletRequest request, HttpServletResponse response) {
		String Title = request.getParameter( "title" );
		String major = request.getParameter( "major" );
		String classname = request.getParameter( "classname" );
		String price = request.getParameter( "price" );
		String grade = request.getParameter( "grade" );
		String content = request.getParameter( "content" );
		String userID = request.getParameter("userID");
		BoardRP dao = new BoardRP();
		dao.write( Title,  major, classname, price, grade , content,userID);
	}
}
