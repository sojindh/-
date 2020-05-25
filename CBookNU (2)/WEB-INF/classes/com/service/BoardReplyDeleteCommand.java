package com.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BoardReply;
import com.dao.BoardRPReply;
import com.dao.BoardFBReply;

public class BoardReplyDeleteCommand implements BoardCommand {

	@Override
	public void executeBP(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String num = request.getParameter("num");
		String id = request.getParameter("id");
		String hostID = request.getParameter("hostID");
		
        BoardReply  rdao = new BoardReply();
        if(rdao.checkhostID(id, hostID))
        	rdao.delete( id );
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
		String id = request.getParameter("id");
		String hostID = request.getParameter("hostID");
		
        BoardFBReply  rdao = new BoardFBReply();
        if(rdao.checkhostID(id, hostID))
        	rdao.delete( id );
        else {
        	response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('삭제 권한이 없습니다.'); location.href='free_board_retrieve.do?num="+num+"';</script>");
            out.flush();
        }
	}
	@Override
	public void executereport(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String num = request.getParameter("num");
		String id = request.getParameter("id");
		String hostID = request.getParameter("hostID");
		
        BoardRPReply  rdao = new BoardRPReply();
        if(rdao.checkhostID(id, hostID))
        	rdao.delete( id );
        else {
        	response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('삭제 권한이 없습니다.'); location.href='report_sale_retrieve.do?num="+num+"';</script>");
            out.flush();
        }
	}
}
