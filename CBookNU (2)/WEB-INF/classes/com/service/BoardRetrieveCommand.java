package com.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.BoardBP;
import com.dao.BoardRP;
import com.entity.BoardRTO;
import com.dao.BoardReply;
import com.dao.BoardRPReply;
import com.entity.BoardDTO;
import com.entity.BoardFBDTO;
import com.entity.PageTO;
import com.dao.BoardFB;
import com.dao.BoardFBReply;


public class BoardRetrieveCommand implements BoardCommand {

	@Override
	public void executeBP(HttpServletRequest request, HttpServletResponse response) {
		
		String num = request.getParameter("num");
		BoardBP  dao = new BoardBP();
		BoardDTO data = dao.retrieve( num );
		
		
		BoardReply rdao = new BoardReply();
		
		int curPage = 1;

		if( request.getParameter( "curPage") != null ) {
				curPage = Integer.parseInt( request.getParameter( "curPage" ));
		}

		PageTO Rlist = rdao.page( curPage, num );

		
		request.setAttribute( "Rlist", Rlist.getRList());
		request.setAttribute( "retrieve" , data );
		request.setAttribute( "page" ,  Rlist );
	}
	
	@Override
	public void executeFB(HttpServletRequest request, HttpServletResponse response) {
		
		String num = request.getParameter("num");
		BoardFB  fdao = new BoardFB();
		BoardFBDTO data = fdao.retrieve(num);
		
		
		BoardFBReply rdao = new BoardFBReply();
		
		int curPage = 1;

		if( request.getParameter( "curPage") != null ) {
				curPage = Integer.parseInt( request.getParameter( "curPage" ));
		}

		PageTO Rlist = rdao.page( curPage, num );

		
		request.setAttribute( "Rlist", Rlist.getRList());
		request.setAttribute( "retrieve" , data );
		request.setAttribute( "page" ,  Rlist );
	}
	public void executereport(HttpServletRequest request, HttpServletResponse response) {
		
		String num = request.getParameter("num");
		BoardRP  dao = new BoardRP();
		BoardRTO data = dao.retrieve(num);
		
		
		BoardRPReply rdao = new BoardRPReply();
		
		int curPage = 1;

		if( request.getParameter( "curPage") != null ) {
				curPage = Integer.parseInt( request.getParameter( "curPage" ));
		}

		PageTO Rlist = rdao.page( curPage, num );

		
		request.setAttribute( "Rlist", Rlist.getRList());
		request.setAttribute( "retrieve" , data );
		request.setAttribute( "page" ,  Rlist );
	}

}
