package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.entity.BoardRTO;
import com.entity.BoardReplyDTO;
import com.entity.PageTO;

public class BoardRPReply {
      String jdbc_driver = "com.mysql.jdbc.Driver";
      String jdbc_url = "jdbc:mysql://127.0.0.1/jspdb";
      Connection con = null;
      public BoardRPReply(){
            try{
               Class.forName(jdbc_driver);
               con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
            }catch(Exception e){ e.printStackTrace();}
         }
         public ArrayList<BoardReplyDTO> Rlist(String _num){
            ArrayList<BoardReplyDTO> Rlist = new ArrayList<BoardReplyDTO>();
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            try{
                   con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
                   String query = "SELECT  id, num, userID, content, DATE_FORMAT( writeday , '%Y-%m-%d') AS writeday FROM rreply WHERE num LIKE ? ";
                   
                   pstmt = con.prepareStatement( query );
                   pstmt.setInt(1, Integer.parseInt( _num ));
                   System.out.println(_num);
                   rs = pstmt.executeQuery( );

                   
                   while( rs.next()){
                      int id = rs.getInt( "id" );
                      int num = rs.getInt( "num" );
                      String userID = rs.getString( "userID" );
                      String content = rs.getString( "content" );
                      String writeday = rs.getString( "writeday" );
                      BoardReplyDTO data = new BoardReplyDTO();
                      data.setId(id);
                      data.setNum( num );
                      data.setuserID(userID);
                      data.setContent( content );
                      data.setWriteday( writeday );
                      Rlist.add( data );
                   }
               
               }catch(Exception e){ 
                  e.printStackTrace();
               }finally{
                  try {
                     if( rs!= null) rs.close();
                     if( pstmt!= null) pstmt.close();
                     if( con!= null) con.close();
                     
                  } catch (SQLException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
                  }
               }
                return Rlist;
            }
         public void Rwrite(String _num, String _content, String _userID){

             Connection con = null;
             PreparedStatement pstmt = null;
             
             try{
                con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
               String query ="INSERT INTO rreply (id, num, content, userID) values (0, ?, ?, ?)";
               pstmt = con.prepareStatement( query );

               pstmt.setInt( 1 , Integer.parseInt( _num ) );
               pstmt.setString( 2, _content );
               pstmt.setString( 3, _userID);
               int n = pstmt.executeUpdate();

             }catch(Exception e){ 
                e.printStackTrace();
             }finally{
                try {
                   if( pstmt!= null) pstmt.close();
                   if( con!= null) con.close();
                } catch (SQLException e) {
                   // TODO Auto-generated catch block
                   e.printStackTrace();
                }
             }
         }
         public boolean checkhostID(String _id, String _hostID) {
        	 String userID="";
             Connection con = null;
             PreparedStatement pstmt = null;
             ResultSet rs = null;
                try{
                   con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
                   String query = "SELECT userID FROM rreply WHERE  id  LIKE  ?";
                   pstmt = con.prepareStatement( query );
                   pstmt.setInt(  1 ,   Integer.parseInt( _id ) );
                   rs = pstmt.executeQuery( );

                 if( rs.next()){
                   userID = rs.getString("userID");
                 }
                  if(userID.equals(_hostID)) {
                	  return true;
                  }
                }catch(Exception e){ 
                   e.printStackTrace();
                }finally{
                   try {
                      if( rs!= null) rs.close();
                      if( pstmt!= null) pstmt.close();
                      if( con!= null) con.close();
                      
                   } catch (SQLException e) {
                      // TODO Auto-generated catch block
                      e.printStackTrace();
                   }
                }
                 return false;
         }
         public void deleteAll(String  _num ){
             
             Connection con = null;
             PreparedStatement pstmt = null;
             
            try{
               con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
               String query = "DELETE FROM rreply WHERE num = ?";
               pstmt = con.prepareStatement( query );
               pstmt.setInt( 1 ,   Integer.parseInt( _num ) );
               int n = pstmt.executeUpdate( );
            }catch( Exception e) { 
               e.printStackTrace();
            }finally{
               try {
                  if( pstmt!= null) pstmt.close();
                  if( con!= null) con.close();
                  
               } catch (SQLException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
               }
            }
         }
         
         public void delete(String _id ){
             
             Connection con = null;
             PreparedStatement pstmt = null;
             
            try{
               con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
               String query = "DELETE FROM rreply WHERE id = ?";
               pstmt = con.prepareStatement( query );
               pstmt.setInt(1 ,   Integer.parseInt( _id ) );
               int n =   pstmt.executeUpdate( );
            }catch( Exception e) { 
               e.printStackTrace();
            }finally{
               try {
                  if( pstmt!= null) pstmt.close();
                  if( con!= null) con.close();
                  
               } catch (SQLException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
               }
            }
         }
         
         public int totalCount(String _num){
             
               int count = 0;
               Connection con = null;
               PreparedStatement pstmt = null;
               ResultSet rs = null;
                  try{
                     con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
                    
                    String query = "SELECT  count(if(num=" + Integer.parseInt( _num ) +","+ Integer.parseInt( _num ) + ",null )) FROM rreply";
                    pstmt = con.prepareStatement( query );
                    rs =   pstmt.executeQuery( );
                  
                   if( rs.next()){
                     count = rs.getInt( 1 );
                   }
                  
                   }catch( Exception e){ 
                       e.printStackTrace();
                    }finally{
                        try {
                           if( rs!= null) rs.close();
                           if( pstmt!= null) pstmt.close();
                           if( con!= null) con.close();
                           
                        } catch (SQLException e) {
                           // TODO Auto-generated catch block
                           e.printStackTrace();
                        }
                     }
                  return count;
         }
         public PageTO page( int curPage, String _num){

              PageTO   to = new PageTO();
              int totalCount = totalCount(_num);

              ArrayList<BoardReplyDTO> Rlist = new ArrayList<BoardReplyDTO>();
              Connection con = null;
              PreparedStatement pstmt = null;
              ResultSet rs = null;
              
                 try{
                    con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
                    String query = "SELECT  id, num , content ,userID,  DATE_FORMAT( writeday , '%Y-%m-%d') AS writeday FROM rreply WHERE num LIKE ?";
                
                    pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
                    pstmt.setInt(1, Integer.parseInt( _num ));
                    System.out.println(_num);
                    rs = pstmt.executeQuery(  );
               
                 int perPage = to.getPerPage(); 
                 int skip = ( curPage - 1 ) * perPage;
                     if( skip > 0 ){
                        rs.absolute( skip );
                     }
                 for( int i = 0 ; i < perPage &&  rs.next() ; i++){
                     int id = rs.getInt("id");
                     int num = rs.getInt( "num" );
                     String content = rs.getString( "content" );
                     String writeday = rs.getString( "writeday" );
                     String userID = rs.getString("userID");
                     BoardReplyDTO data = new BoardReplyDTO();
                     data.setNum( num );
                     data.setId(id);
                     data.setuserID(userID);
                     data.setContent( content );
                     data.setWriteday( writeday );
                     Rlist.add( data );
                  }
                     
                     to.setRList( Rlist ); 
                     to.setTotalCount( totalCount ); 
                     to.setCurPage( curPage ); 

                 }catch( Exception e){ 
                    e.printStackTrace();
                 }finally{
                     try {
                        if( rs!= null) rs.close();
                        if( pstmt!= null) pstmt.close();
                        if( con!= null) con.close();
                        
                     } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                     }
                  }
                  return to;
            }
}