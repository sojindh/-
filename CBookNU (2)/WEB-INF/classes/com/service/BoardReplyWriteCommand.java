package com.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BoardReply;
import com.dao.BoardRPReply;
import com.dao.BoardFBReply;

public class BoardReplyWriteCommand implements BoardCommand{
	@Override
	public void executeBP(HttpServletRequest request, HttpServletResponse response) {
		
		
		String content = request.getParameter( "recontent" );
		String num = request.getParameter( "num" );
		String userID = request.getParameter("userID");
		BoardReply dao = new BoardReply();
		dao.Rwrite(num, content ,userID);
	}

	@Override
	public void executeFB(HttpServletRequest request, HttpServletResponse response) {
		
		
		String content = request.getParameter( "recontent" );
		String num = request.getParameter( "num" );
		String userID = request.getParameter("userID");
		BoardFBReply dao = new BoardFBReply();
		dao.Rwrite(num, content ,userID);
	}
	
	public void executereport(HttpServletRequest request, HttpServletResponse response) {
		
		
		String content = request.getParameter( "recontent" );
		String num = request.getParameter( "num" );
		String userID = request.getParameter("userID");
		BoardRPReply dao = new BoardRPReply();
		dao.Rwrite(num, content, userID );
	}
}
