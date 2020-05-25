package com.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BoardBP;
import com.dao.BoardFB;
import com.dao.BoardRP;
import com.entity.BoardDTO;
import com.entity.BoardFBDTO;
import com.entity.BoardRTO;
public class BoardSearchCommand implements BoardCommand {

	@Override
	public void executeBP(HttpServletRequest request, HttpServletResponse response) {
		
		String searchName = request.getParameter( "searchName");
		String searchValue = request.getParameter( "searchValue" );

		BoardBP dao = new BoardBP();

		ArrayList<BoardDTO>  list = dao.search( searchName ,  searchValue );

		request.setAttribute(  "list"  ,   list );
	}

	@Override
	public void executeFB(HttpServletRequest request, HttpServletResponse response) {
		String searchName = request.getParameter( "searchName" );
		String searchValue = request.getParameter( "searchValue" );

		BoardFB dao = new BoardFB();

		ArrayList<BoardFBDTO>  list = dao.search( searchName ,  searchValue );

		request.setAttribute(  "Flist"  ,   list );
	}
	
	public void executereport(HttpServletRequest request, HttpServletResponse response) {
		String searchName = request.getParameter( "searchName" );
		String searchValue = request.getParameter( "searchValue" );

		BoardRP dao = new BoardRP();

		ArrayList<BoardRTO>  list = dao.search( searchName ,  searchValue );

		request.setAttribute(  "RSlist"  ,   list );


	}
}
