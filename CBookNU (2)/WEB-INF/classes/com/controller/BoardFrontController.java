package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.BoardChangeCommand;
import com.service.BoardCommand;
import com.service.BoardDeleteCommand;

import com.service.BoardPageCommand;
import com.service.BoardReplyWriteCommand;
import com.service.BoardRetrieveCommand;
import com.service.BoardSearchCommand;
import com.service.BoardUpdateCommand;
import com.service.BoardWriteCommand;
import com.service.JoinCommand;
import com.service.JoinRegisterCommand;
import com.service.BoardReplyDeleteCommand;

@SuppressWarnings("serial")
@WebServlet("*.do")
public class BoardFrontController extends HttpServlet {

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      request.setCharacterEncoding("UTF-8");
      
      String requestURI = request.getRequestURI();
      String contextPath = request.getContextPath();
      String com = requestURI.substring(contextPath.length());
      
      JoinCommand command1 = null;
      BoardCommand command  = null;
      String nextPage = null;
      
      
      if(com.equals("/book_sale_writeui.do")){
         nextPage = "book_sale_write.jsp";
      }
      if(com.equals("/free_board_writeui.do")){
         nextPage = "free_board_write.jsp";
      }
      
      if(com.equals("/book_sale_write.do")){
         command = new BoardWriteCommand();
         command.executeBP(request, response);
         nextPage = "book_sale.do";
      }
      if(com.equals("/free_board_write.do")){
         command = new BoardWriteCommand();
         command.executeFB(request, response);
         nextPage = "free_board.do";
      }
      
      if(com.equals("/book_sale_retrieve.do")){
         command = new BoardRetrieveCommand();
         command.executeBP(request, response);
         nextPage = "book_sale_retrieve.jsp";
      }   
      if(com.equals("/free_board_retrieve.do")){
         command = new BoardRetrieveCommand();
         command.executeFB(request, response);
         nextPage = "free_board_retrieve.jsp";
      }   
      
      if(com.equals("/book_sale_update.do")){
         command = new BoardUpdateCommand();
         command.executeBP(request, response);
         nextPage = "book_sale.do";
      }   
      if(com.equals("/free_board_update.do")){
         command = new BoardUpdateCommand();
         command.executeFB(request, response);
         nextPage = "free_board.do";
      }
      
      if(com.equals("/book_sale_delete.do")){
         command = new BoardDeleteCommand();
         command.executeBP(request, response);
         nextPage = "book_sale.do";
      }   
      if(com.equals("/free_board_delete.do")){
         command = new BoardDeleteCommand();
         command.executeFB(request, response);
         nextPage = "free_board.do";
      }   
      
      if(com.equals("/book_sale_search.do")){
         command = new BoardSearchCommand();
         command.executeBP(request, response);
         nextPage = "book_sale_search.jsp";
      }   
      if(com.equals("/free_board_search.do")){
         command = new BoardSearchCommand();
         command.executeFB(request, response);
         nextPage = "free_board_search.jsp";
      }
      
      if(com.equals("/book_sale_reply_write.do")){
         command = new BoardReplyWriteCommand();
         command.executeBP(request, response);
         nextPage = "book_sale_retrieve.do";
      }   
      if(com.equals("/free_board_reply_write.do")){
         command = new BoardReplyWriteCommand();
         command.executeFB(request, response);
         nextPage = "free_board_retrieve.do";
      }
      if(com.equals("/report_sale_reply_write.do")){
         command = new BoardReplyWriteCommand();
         command.executereport(request, response);
         nextPage = "report_sale_retrieve.do";
      }
      if(com.equals("/reply_delete.do")){
         command = new BoardReplyDeleteCommand();
         command.executeBP(request, response);
         nextPage = "book_sale_retrieve.do";
      }   
      if(com.equals("/free_board_reply_delete.do")){
         command = new BoardReplyDeleteCommand();
         command.executeFB(request, response);
         nextPage = "free_board_retrieve.do";
      }   
      if(com.equals("/report_sale_reply_delete.do")){
         command = new BoardReplyDeleteCommand();
         command.executereport(request, response);
         nextPage = "report_sale_retrieve.do";
      }   
      if(com.equals("/book_sale.do")){
         command = new BoardPageCommand();
         command.executeBP(request, response);
         nextPage = "book_sale.jsp";
      }
      if(com.equals("/free_board.do")){
         command = new BoardPageCommand();
         command.executeFB(request, response);
         nextPage = "free_board.jsp";
      }   
      
      if(com.equals("/book_sale_change.do")){
         command = new BoardChangeCommand();
         command.executeBP(request, response);
         nextPage = "book_sale_change.jsp";
      }   
      if(com.equals("/free_board_change.do")){
         command = new BoardChangeCommand();
         command.executeFB(request, response);
         nextPage = "free_board_change.jsp";
      }   
      
      if(com.equals("/report_sale_writeui.do")){
         nextPage = "report_sale_write.jsp";
      }
      
      if(com.equals("/report_sale_write.do")){
         command = new BoardWriteCommand();
         command.executereport(request,response);
         nextPage = "report_sale.do";
      }
      
      if(com.equals("/report_sale_retrieve.do")){
         command = new BoardRetrieveCommand();
         command.executereport(request,response);
         nextPage = "report_sale_retrieve.jsp";
      }   
      
      
      if(com.equals("/report_sale_update.do")){
         command = new BoardUpdateCommand();
         command.executereport(request,response);
         nextPage = "report_sale.do";
      }   
      
      
      if(com.equals("/report_sale_delete.do")){
         command = new BoardDeleteCommand();
         command.executereport(request,response);
         nextPage = "report_sale.do";
      }   
      
      if(com.equals("/report_sale_search.do")){
         command = new BoardSearchCommand();
         command.executereport(request,response);
         nextPage = "report_sale_search.jsp";
      }   
      
      if(com.equals("/report_sale.do")){
         command = new BoardPageCommand();
         command.executereport(request,response);
         nextPage = "report_sale.jsp";
      }   
      if(com.equals("/report_sale_change.do")){
         command = new BoardChangeCommand();
         command.executereport(request,response);
         nextPage = "report_sale_change.jsp";
      }   
      ////////////// 회원가입 /////
      if(com.equals("/join.do")){
			command1 = new JoinRegisterCommand();
			boolean b = command1.execute(request,response);
			if(b) {
				nextPage = "index.jsp";
			}
			else {
				nextPage = "join.jsp";
			}
		}
      RequestDispatcher dis = request.getRequestDispatcher(nextPage);
      dis.forward(request, response);
   }

}