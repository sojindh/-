package com.dao;

import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import com.entity.BoardDTO;
import com.entity.PageTO;
import java.sql.*;
public class BoardBP {
   String jdbc_driver = "com.mysql.jdbc.Driver";
   String jdbc_url = "jdbc:mysql://127.0.0.1/jspdb";
   Connection con = null;
   
      public BoardBP(){
         try{
            Class.forName(jdbc_driver);
            con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
         }catch(Exception e){ e.printStackTrace();}
      }
      public ArrayList<BoardDTO> list(){
         ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
         PreparedStatement pstmt = null;
         ResultSet rs = null;
         try{
                con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
                String query = "SELECT  num , author, title, major, publisher, price, content ,userID,  DATE_FORMAT( writeday , '%Y-%m-%d') AS writeday ,  readcnt FROM board";
                pstmt = con.prepareStatement(query);
                rs = pstmt.executeQuery();

                while( rs.next()){
                   int num = rs.getInt( "num" );
                   String userID = rs.getString("userID");
                   String author = rs.getString( "author" );
                   String title = rs.getString( "title" );
                   String major = rs.getString( "major" );
                   String publisher = rs.getString( "publisher" );
                   String price = rs.getString( "price" );
                   String content = rs.getString( "content" );
                   String writeday = rs.getString( "writeday" );
                   int readcnt = rs.getInt( "readcnt" );
                   BoardDTO data = new BoardDTO();
                   data.setuserID(userID);
                   data.setNum( num );
                   data.setAuthor( author );
                   data.setTitle( title );
                   data.setMajor( major );
                   data.setPublisher( publisher );
                   data.setPrice( price );
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
      
      public void write( String _title, String _major, String _publisher, String _price, String _author, String _content, String _userID){

         Connection con = null;
         PreparedStatement pstmt = null;
         
         try{
            con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
           String query =" INSERT INTO board ( num , title, major, publisher, price, author , content, userID) values ( 0,?,?,?,?,?,?,?)";
           pstmt = con.prepareStatement( query );

           pstmt.setString( 1, _title );
           pstmt.setString( 2, _major );
           pstmt.setString( 3, _publisher );
           pstmt.setString( 4, _price );
           pstmt.setString( 5, _author );
           pstmt.setString( 6, _content );
           pstmt.setString( 7, _userID );

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
                 String query = "UPDATE board SET readcnt = readcnt + 1 WHERE num="+ _num;
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
        

      public BoardDTO retrieve( String _num ){
          readCount(  _num );
          Connection con = null;
          PreparedStatement pstmt = null;
          ResultSet rs = null;
          BoardDTO data = new BoardDTO();
          try{
             con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
               
               String query = "SELECT * FROM board WHERE num = ?";
               pstmt = con.prepareStatement( query );
               pstmt.setInt(  1 ,   Integer.parseInt( _num ) );
               rs= pstmt.executeQuery();

               if( rs.next()){
                  int num = rs.getInt( "num" );
                  String title = rs.getString( "title" );
                  String major = rs.getString( "major" );
                  String publisher = rs.getString( "publisher" );
                  String price = rs.getString( "price" );
                  String author = rs.getString( "author" );
                  String content = rs.getString( "content" );
                  String writeday = rs.getString( "writeday" );
                  int readcnt = rs.getInt( "readcnt" );

                  data.setNum( num );
                  data.setTitle( title );
                  data.setMajor( major );
                   data.setPublisher( publisher );
                   data.setPrice( price );
                  data.setAuthor( author );
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
      
      public void update( String  _num , String  _title , String _major, String _publisher, String _price, String  _author , String  _content ){
            
          Connection con = null;
          PreparedStatement pstmt = null;
         
          
         try{
            con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
                  String query = "UPDATE board SET  title = ?  , major = ? , publisher = ?, price = ?, author = ? , content = ?  WHERE num = ?";

                  pstmt = con.prepareStatement( query );

                  pstmt.setString ( 1 , _title );
                  pstmt.setString( 2, _major );
                  pstmt.setString( 3, _publisher );
                  pstmt.setString( 4, _price );
                  pstmt.setString( 5,  _author );
                  pstmt.setString( 6 ,  _content );
                  pstmt.setInt(  7 ,   Integer.parseInt( _num ) );

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
                String query = "SELECT userID FROM board WHERE  num  LIKE  ?";
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
            String query = "DELETE FROM board WHERE num = ?";
            pstmt = con.prepareStatement( query );
            pstmt.setInt(  1 ,   Integer.parseInt( _num ) );
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
      
      public ArrayList<BoardDTO>  search( String  _searchName,String _searchValue)   {
         ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
         Connection con = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;
            try{
               con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
               String query = "SELECT  num ,userID, author, title, major, publisher, price, content ,  DATE_FORMAT( writeday , '%Y-%m-%d') AS writeday ,  readcnt FROM board";
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
               String userID = rs.getString("userID");
               String author = rs.getString( "author" );
               String title = rs.getString( "title" );
               String major = rs.getString( "major" );
               String publisher = rs.getString( "publisher" );
               String price = rs.getString( "price" );
               String content = rs.getString( "content" );
               String writeday = rs.getString( "writeday" );
               int readcnt = rs.getInt( "readcnt" );
               
               BoardDTO data = new BoardDTO();
               data.setuserID(userID);
               data.setNum( num );
               data.setAuthor( author );
               data.setTitle( title );
               data.setMajor( major );
               data.setPublisher( publisher );
               data.setPrice( price );
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

      public BoardDTO replyui( String  _num ){
         
         BoardDTO data = new BoardDTO();
         Connection con = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;
         
          try{
             con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
               
                String query = "SELECT * FROM board WHERE  num = ?";
                pstmt = con.prepareStatement( query );
                pstmt.setInt(  1 ,   Integer.parseInt( _num ) );
                  
                rs  =  pstmt.executeQuery();

            if( rs.next()){
               data.setNum(  rs.getInt( "num" ));
               data.setTitle( rs.getString( "title" ));
               data.setMajor(  rs.getString( "major" ));
               data.setPublisher(  rs.getString( "publisher" ));
               data.setPrice(  rs.getString( "price" ));
               data.setAuthor( rs.getString( "author" ));
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
                 
                 String query = "SELECT  count(*) FROM board";
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
      public PageTO page( int curPage ){

           PageTO   to = new PageTO();
           int totalCount = totalCount();

           ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
           Connection con = null;
           PreparedStatement pstmt = null;
           ResultSet rs = null;
            
              try{
                 con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
          String query = "SELECT  num, author, title, major, publisher, price, content, userID,  DATE_FORMAT( writeday , '%Y-%m-%d') AS writeday ,  readcnt FROM board order by num desc";
             
          pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
          rs = pstmt.executeQuery(  );
            
              int perPage = to.getPerPage(); 
              int skip = ( curPage - 1 ) * perPage;
                  if( skip > 0 ){
                     rs.absolute( skip );
                  }
                  for( int i = 0 ; i < perPage &&  rs.next() ; i++){
                  int num = rs.getInt( "num" );
                  String author = rs.getString( "author" );
                  String userID  = rs.getString("userID");
                  String title = rs.getString( "title" );
                  String major = rs.getString( "major" );
                  String publisher = rs.getString( "publisher" );
                  String price = rs.getString( "price" );
                  String content = rs.getString( "content" );
                  String writeday = rs.getString( "writeday" );
                  int readcnt = rs.getInt( "readcnt" );
                  BoardDTO data = new BoardDTO();
                  data.setNum( num );
                  data.setAuthor( author );
                  data.setTitle( title );
                  data.setMajor( major );
                  data.setuserID( userID);
                  data.setPublisher( publisher );   
                  data.setPrice( price );
                  data.setContent( content );
                  data.setWriteday( writeday );
                  data.setReadcnt( readcnt );
                  list.add( data );
               }
                  
                  to.setList( list ); 
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