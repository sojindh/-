<%@ page contentType="text/html; charset=utf-8"%>

<%@ page import="com.entity.PageTO" %>
<% request.setCharacterEncoding("utf-8"); %> 
<%
		PageTO to  = (PageTO)request.getAttribute( "page" );
		String num = request.getParameter("num");
		int curPage = to.getCurPage();
		int perPage = to.getPerPage();
		int totalCount  = to.getTotalCount();
		int totalPage = totalCount / perPage;  // 보여줄 페이지 번호개수
		if( totalCount  %  perPage  != 0 ) totalPage++;
		out.print( "<div style= 'text-align:center'>");	
		for( int i = 1 ; i <=  totalPage ; i++){

          if(  curPage == i ){
			 out.print( "<font size=5 color='red'>"+i +"</font>" );				
		  }else{
			out.print( "<a href='free_board.do?curPage="+i+"'>"+i+"</a>&nbsp;" );
		  }//end if
		}
		out.print( "</div>" );
%>
		