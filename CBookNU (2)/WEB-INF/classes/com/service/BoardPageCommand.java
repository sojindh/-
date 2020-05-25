package com.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BoardBP;
import com.dao.BoardFB;
import com.dao.BoardRP;
import com.entity.PageTO;


public class BoardPageCommand implements BoardCommand {

	@Override
	public void executeBP(HttpServletRequest request, HttpServletResponse response) {
		
		int curPage = 1;

		if( request.getParameter( "curPage") != null ) {
				curPage = Integer.parseInt( request.getParameter( "curPage" ));
		}//

		BoardBP dao = new BoardBP();
		PageTO list = dao.page( curPage );

		request.setAttribute( "list" ,  list.getList() );
		request.setAttribute( "page" ,  list );
	}
	@Override
	public void executeFB(HttpServletRequest request, HttpServletResponse response) {
		
		int curPage = 1;

		if( request.getParameter( "curPage") != null ) {
				curPage = Integer.parseInt( request.getParameter( "curPage" ));
		}//

		BoardFB dao = new BoardFB();
		PageTO list = dao.page( curPage );

		request.setAttribute( "Flist" ,  list.getFList() );
		request.setAttribute( "page" ,  list );
	}
	public void executereport(HttpServletRequest request, HttpServletResponse response) {
		
		int curPage = 1; 

		if( request.getParameter( "curPage") != null ) {
				curPage = Integer.parseInt( request.getParameter( "curPage" ));
		}//

		BoardRP dao = new BoardRP();
		PageTO list = dao.page( curPage );

		request.setAttribute( "RSlist" ,  list.getRSList() );
		request.setAttribute( "page" ,  list );
	}
}
