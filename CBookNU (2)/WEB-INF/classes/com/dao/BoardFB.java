package com.dao;

import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import com.entity.BoardDTO;
import com.entity.BoardFBDTO;
import com.entity.PageTO;
import java.sql.*;
public class BoardFB {
   String jdbc_driver = "com.mysql.jdbc.Driver";
   String jdbc_url = "jdbc:mysql://127.0.0.1/jspdb";
   Connection con = null;
   
      public BoardFB(){
         try{
            Class.forName(jdbc_driver);
            con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
         }catch(Exception e){ e.printStackTrace();}
      }
      public ArrayList<BoardFBDTO> list(){
         ArrayList<BoardFBDTO> list = new ArrayList<BoardFBDTO>();
         PreparedStatement pstmt = null;
         ResultSet rs = null;
         try{
                con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
                String query = "SELECT  num,userID, content ,  DATE_FORMAT( writeday , '%Y-%m-%d') AS writeday ,  readcnt FROM freeb";
                pstmt = con.prepareStatement(query);
                rs = pstmt.executeQuery();

                while( rs.next()){
                   int num = rs.getInt( "num" );
                   String title = rs.getString( "title" );
                   String content = rs.getString( "content" );
                   String writeday = rs.getString( "writeday" );
                   String userID = rs.getString("userID");
                   int readcnt = rs.getInt( "readcnt" );
                   BoardFBDTO data = new BoardFBDTO();
                   data.setNum( num );
                   data.setuserID( userID );
                   data.setTitle( title );
                   data.setContent( content );
                   data.setWriteday( writeday );
                   data.setReadcnt( readcnt );
                   list.add( data );
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
             return list;
         }
      
      public void write( String _title, String _userID, String _content){

         Connection con = null;
         PreparedStatement pstmt = null;
         
         try{
           con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
           String query =" INSERT INTO freeb ( num , title, userID , content,readcnt ) values ( 0,?,?,?,0)";
           pstmt = con.prepareStatement( query );

           pstmt.setString( 1, _title );
           pstmt.setString( 2, _userID );
           pstmt.setString( 3, _content );
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
      

        public  void readCount( String  _num ){
            
           Connection con = null;
           PreparedStatement pstmt = null;
            try{
               con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
                 String query = "UPDATE freeb SET readcnt = readcnt + 1 WHERE num="+ _num;
                 pstmt = con.prepareStatement( query );
                 int n = pstmt.executeUpdate( );

            }catch( Exception e){ 
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
        

      public BoardFBDTO retrieve(String _num ){
          readCount(_num);
          Connection con = null;
          PreparedStatement pstmt = null;
          ResultSet rs = null;
          BoardFBDTO data = new BoardFBDTO();
          try{
             con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
               
               String query = "SELECT * FROM freeb WHERE num = ?";
               pstmt = con.prepareStatement( query );
               pstmt.setInt(  1 ,   Integer.parseInt( _num ) );
               rs= pstmt.executeQuery();

               if( rs.next()){
                  int num = rs.getInt( "num" );
                  String title = rs.getString( "title" );
                  String userID = rs.getString( "userID" );
                  String content = rs.getString( "content" );
                  String writeday = rs.getString( "writeday" );
                  int readcnt = rs.getInt( "readcnt" );

                  data.setNum( num );
                  data.setTitle( title );
                  data.setuserID( userID );
                  data.setContent( content );
                  data.setWriteday( writeday );
                  data.setReadcnt( readcnt );
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
                return data; 
         
      }
      
      public void update( String  _num , String  _title, String  _content ){
            
          Connection con = null;
          PreparedStatement pstmt = null;
         
          
         try{
            con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
                  String query = "UPDATE freeb SET  title = ? , content = ?  WHERE num = ?";

                  pstmt = con.prepareStatement( query );

                  pstmt.setString ( 1 , _title );
                  pstmt.setString( 2 ,  _content );
                  pstmt.setInt(  3 ,   Integer.parseInt( _num ) );

                int n = pstmt.executeUpdate();

            }catch( Exception e){ 
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
      public boolean checkNUM(String _num, String _hostID) {
          String userID="";
           Connection con = null;
           PreparedStatement pstmt = null;
           ResultSet rs = null;
              try{
                 con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
                 String query = "SELECT userID FROM freeb WHERE  num  LIKE  ?";
                 pstmt = con.prepareStatement( query );
                 pstmt.setInt(  1 ,   Integer.parseInt( _num ) );
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

      public void delete( String   _num ){
         
          Connection con = null;
          PreparedStatement pstmt = null;
          
         try{
            con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
            String query = "DELETE FROM freeb WHERE num = ?";
            pstmt = con.prepareStatement( query );
            pstmt.setInt(1 ,   Integer.parseInt( _num ) );
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
      
      public ArrayList<BoardFBDTO>  search( String  _searchName,String _searchValue)   {
         ArrayList<BoardFBDTO> list = new ArrayList<BoardFBDTO>();
         Connection con = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;
            try{
               con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
               String query = "SELECT  num , userID, title, content , DATE_FORMAT( writeday , '%Y-%m-%d') AS writeday ,  readcnt FROM freeb";
              if(  _searchName.equals( "userID" )){
                   query += "     WHERE  userID  LIKE  ?";
              }
              
              else if(  _searchName.equals( "title" )){
                   query += "    WHERE  title LIKE ?";
             }
              else {
                 query += "     WHERE  major  LIKE  ?";
              }
             
             pstmt = con.prepareStatement( query );
             pstmt.setString(1, "%"+_searchValue+"%" );
             System.out.println(_searchValue);
             rs = pstmt.executeQuery( );

             while( rs.next()){
               int num = rs.getInt( "num" );
               String userID = rs.getString( "userID" );
               String title = rs.getString( "title" );
               String content = rs.getString( "content" );
               String writeday = rs.getString( "writeday" );
               int readcnt = rs.getInt( "readcnt" );
               
               BoardFBDTO data = new BoardFBDTO();
               data.setNum( num );
               data.setuserID( userID );
               data.setTitle( title );
               data.setContent( content );
               data.setWriteday( writeday );
               data.setReadcnt( readcnt );
               list.add( data );
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
             return list;
         }

      public BoardFBDTO replyui( String  _num ){
         
         BoardFBDTO data = new BoardFBDTO();
         Connection con = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;
         
          try{
             con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
               
                String query = "SELECT * FROM freeb WHERE  num = ?";
                pstmt = con.prepareStatement( query );
                pstmt.setInt(  1 ,   Integer.parseInt( _num ) );
                  
                rs  =  pstmt.executeQuery();

            if( rs.next()){
               data.setNum(  rs.getInt( "num" ));
               data.setTitle( rs.getString( "title" ));
               data.setuserID( rs.getString( "userID" ));
               data.setContent( rs.getString( "content" ));
               data.setWriteday( rs.getString( "writeday" ));
               data.setReadcnt( rs.getInt( "readcnt" ));
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
               return data;
      }

      
      public int totalCount(){
         
            int count = 0;
            Connection con = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
               try{
                  con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
                 
                 String query = "SELECT  count(*) FROM freeb";
                 pstmt = con.prepareStatement( query );
                 rs =   pstmt.executeQuery();
               
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
      public PageTO page( int curPage ){

           PageTO   to = new PageTO();
           int totalCount = totalCount();

           ArrayList<BoardFBDTO> list = new ArrayList<BoardFBDTO>();
           Connection con = null;
           PreparedStatement pstmt = null;
           ResultSet rs = null;
            
              try{
                 con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
          String query = "SELECT  num , userID, title, content , DATE_FORMAT( writeday , '%Y-%m-%d') AS writeday ,  readcnt FROM freeb order by num DESC";
             
          pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
          rs = pstmt.executeQuery(  );
            
              int perPage = to.getPerPage(); 
              int skip = ( curPage - 1 ) * perPage;
                  if( skip > 0 ){
                     rs.absolute( skip );
                  }
                  for( int i = 0 ; i < perPage &&  rs.next() ; i++){
                  int num = rs.getInt( "num" );
                  String userID = rs.getString( "userID" );
                  String title = rs.getString( "title" );
                  String content = rs.getString( "content" );
                  String writeday = rs.getString( "writeday" );
                  int readcnt = rs.getInt( "readcnt" );
                  BoardFBDTO data = new BoardFBDTO();
                  data.setNum( num );
                  data.setuserID(userID );
                  data.setTitle( title );
                  data.setContent( content );
                  data.setWriteday( writeday );
                  data.setReadcnt( readcnt );
                  list.add( data );
               }
                  
                  to.setFList( list ); 
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