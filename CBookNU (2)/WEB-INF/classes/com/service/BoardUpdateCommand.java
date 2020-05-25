package com.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.BoardBP;
import com.dao.BoardFB;
import com.dao.BoardRP;

public class BoardUpdateCommand implements BoardCommand {

	@Override
	public void executeBP(HttpServletRequest request, HttpServletResponse response) {
		
		String num = request.getParameter("num");
		String title = request.getParameter( "title" );
		String major = request.getParameter( "major" );
		String publisher = request.getParameter( "publisher" );
		String price = request.getParameter( "price" );
		String author = request.getParameter( "author" );
		String content = request.getParameter( "content" );
		BoardBP  dao = new BoardBP();
		dao.update( num , title, major, publisher, price, author, content );
	}
	
	@Override
	public void executeFB(HttpServletRequest request, HttpServletResponse response) {
		
		String num = request.getParameter("num");
		String title = request.getParameter( "title" );
		String userID = request.getParameter( "userID" );
		String content = request.getParameter( "content" );
		BoardFB  dao = new BoardFB();
		dao.update( num , title, content );
	}
	
	public void executereport(HttpServletRequest request, HttpServletResponse response) {
		
		String num = request.getParameter("num");
		String Title = request.getParameter( "title" );
		String major = request.getParameter( "major" );
		String classname = request.getParameter( "classname" );
		String price = request.getParameter( "price" );
		String grade = request.getParameter( "grade" );
		String content = request.getParameter( "content" );
		BoardRP  dao = new BoardRP();
		dao.update( num , Title, major, classname, price, grade, content );

	}
}
