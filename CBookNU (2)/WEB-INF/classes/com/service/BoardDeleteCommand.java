package com.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BoardBP;
import com.dao.BoardFB;
import com.dao.BoardRP;
import com.dao.BoardRPReply;
import com.dao.BoardReply;
import com.dao.BoardFBReply;

public class BoardDeleteCommand implements BoardCommand {

	@Override
	public void executeBP(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String num = request.getParameter("num");
		String hostID = request.getParameter("hostID");
        BoardBP  dao = new BoardBP();
        BoardReply  rdao = new BoardReply();
        if(dao.checkNUM(num, hostID)) {
        	dao.delete( num );
        	rdao.deleteAll( num );
        }
        else {
        	response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('삭제 권한이 없습니다.'); location.href='book_sale_retrieve.do?num="+num+"';</script>");
            out.flush();
        }
	}
	@Override
	public void executeFB(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String num = request.getParameter("num");
		String hostID = request.getParameter("hostID");
        BoardFB  dao = new BoardFB();
        BoardFBReply  rdao = new BoardFBReply();
        if(dao.checkNUM(num, hostID)) {
        	dao.delete( num );
        	rdao.deleteAll( num );
        }
        else {
        	response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('삭제 권한이 없습니다.'); location.href='free_board_retrieve.do?num="+num+"';</script>");
            out.flush();
        }
	}
	public void executereport(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String num = request.getParameter("num");
		String hostID = request.getParameter("hostID");
        BoardRP  dao = new BoardRP();
        BoardRPReply  rdao = new BoardRPReply();
        if(dao.checkNUM(num, hostID)) {
        	dao.delete( num );
        	rdao.deleteAll( num );
        }
        else {
        	response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('삭제 권한이 없습니다.'); location.href='report_sale_retrieve.do?num="+num+"';</script>");
            out.flush();
        }
	}
}
