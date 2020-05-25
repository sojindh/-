package com.dao;

import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import com.entity.BoardRTO;
import com.entity.PageTO;
import java.sql.*;
public class BoardRP {
   String jdbc_driver = "com.mysql.jdbc.Driver";
   String jdbc_url = "jdbc:mysql://127.0.0.1/jspdb";
   Connection con = null;
   
      public BoardRP(){
         try{
            Class.forName(jdbc_driver);
            con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
         }catch(Exception e){ e.printStackTrace();}
      }
      public ArrayList<BoardRTO> list(){
         ArrayList<BoardRTO> list = new ArrayList<BoardRTO>();
         PreparedStatement pstmt = null;
         ResultSet rs = null;
         try{
                con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
                String query = "SELECT  num , grade, title, major, classname, price, content ,userID,  DATE_FORMAT( writeday , '%Y-%m-%d') AS writeday ,  readcnt from rboard";
                pstmt = con.prepareStatement(query);
                rs = pstmt.executeQuery();

                while( rs.next()){
                   int num = rs.getInt( "num" );
                   String grade = rs.getString( "grade" );
                   String title = rs.getString( "title" );
                   String major = rs.getString( "major" );
                   String classname = rs.getString( "classname" );
                   String price = rs.getString( "price" );
                   String content = rs.getString( "content" );
                   String writeday = rs.getString( "writeday" );
                   String userID = rs.getString("userID");
                   int readcnt = rs.getInt( "readcnt" );
                   BoardRTO data = new BoardRTO();
                   data.setNum( num );
                   data.setgrade( grade );
                   data.setTitle( title );
                   data.setMajor( major );
                   data.setclassname( classname );
                   data.setPrice( price );
                   data.setContent( content );
                   data.setWriteday( writeday );
                   data.setReadcnt( readcnt );
                   data.setuserID(userID);
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
      
      public void write( String _title, String _major, String _classname, String _price, String _grade, String _content, String _userID){

         Connection con = null;
         PreparedStatement pstmt = null;
         
         try{
            con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
           String query =" INSERT into rboard ( num , title, major, classname, price, grade , content, userID, readcnt) values ( 0,?,?,?,?,?,?,?,0)";
           pstmt = con.prepareStatement( query );

           pstmt.setString( 1, _title );
           pstmt.setString( 2, _major );
           pstmt.setString( 3, _classname );
           pstmt.setString( 4, _price );
           pstmt.setString( 5, _grade );
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
                 String query = "update rboard SET readcnt = readcnt + 1 WHERE num="+ _num;
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
        

      public BoardRTO retrieve( String  _num ){
         readCount(  _num );
          Connection con = null;
          PreparedStatement pstmt = null;
          ResultSet rs = null;
          BoardRTO data = new BoardRTO();
          try{
             con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
               
               String query = "SELECT * from rboard WHERE num = ?";
               pstmt = con.prepareStatement( query );
               pstmt.setInt(  1 ,   Integer.parseInt( _num ) );
               rs= pstmt.executeQuery();

               if( rs.next()){
                  int num = rs.getInt( "num" );
                  String title = rs.getString( "title" );
                  String major = rs.getString( "major" );
                  String classname = rs.getString( "classname" );
                  String price = rs.getString( "price" );
                  String grade = rs.getString( "grade" );
                  String content = rs.getString( "content" );
                  String writeday = rs.getString( "writeday" );
                  int readcnt = rs.getInt( "readcnt" );

                  data.setNum( num );
                  data.setTitle( title );
                  data.setMajor( major );
                   data.setclassname( classname );
                   data.setPrice( price );
                  data.setgrade( grade );
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
      
      public void update( String  _num , String  _title , String _major, String _classname, String _price, String  _grade , String  _content ){
            
          Connection con = null;
          PreparedStatement pstmt = null;
         
          
         try{
            con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
                  String query = "update rboard SET  title = ?  , major = ? , classname = ?, price = ?, grade = ? , content = ?  WHERE num = ?";

                  pstmt = con.prepareStatement( query );

                  pstmt.setString ( 1 , _title );
                  pstmt.setString( 2, _major );
                  pstmt.setString( 3, _classname );
                  pstmt.setString( 4, _price );
                  pstmt.setString( 5,  _grade );
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
                 String query = "SELECT userID FROM rboard WHERE  num  LIKE  ?";
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
            String query = "DELETE from rboard WHERE num = ?";
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
      
      public ArrayList<BoardRTO>  search( String  _searchName,String _searchValue)   {
         ArrayList<BoardRTO> list = new ArrayList<BoardRTO>();
         Connection con = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;
            try{
               con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
               String query = "SELECT  num , grade, title, major, classname, price, content , userID, DATE_FORMAT( writeday , '%Y-%m-%d') AS writeday ,  readcnt from rboard";
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
               String grade = rs.getString( "grade" );
               String title = rs.getString( "title" );
               String major = rs.getString( "major" );
               String classname = rs.getString( "classname" );
               String price = rs.getString( "price" );
               String content = rs.getString( "content" );
               String writeday = rs.getString( "writeday" );
               String userID = rs.getString("userID");
               int readcnt = rs.getInt( "readcnt" );
               
               BoardRTO data = new BoardRTO();
               data.setNum( num );
               data.setgrade( grade );
               data.setTitle( title );
               data.setMajor( major );
               data.setclassname( classname );
               data.setPrice( price );
               data.setContent( content );
               data.setWriteday( writeday );
               data.setReadcnt( readcnt );
               data.setuserID(userID);
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

      public BoardRTO replyui( String  _num ){
         
         BoardRTO data = new BoardRTO();
         Connection con = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;
         
          try{
             con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
               
                String query = "SELECT * from rboard WHERE  num = ?";
                pstmt = con.prepareStatement( query );
                pstmt.setInt(  1 ,   Integer.parseInt( _num ) );
                  
                rs  =  pstmt.executeQuery();

            if( rs.next()){
               data.setNum(  rs.getInt( "num" ));
               data.setTitle( rs.getString( "title" ));
               data.setMajor(  rs.getString( "major" ));
               data.setclassname(  rs.getString( "classname" ));
               data.setPrice(  rs.getString( "price" ));
               data.setgrade( rs.getString( "grade" ));
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
                 
                 String query = "SELECT  count(*) from rboard";
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
      public PageTO  page( int curPage ){

           PageTO   to = new PageTO();
           int totalCount = totalCount();

           ArrayList<BoardRTO> list = new ArrayList<BoardRTO>();
           Connection con = null;
           PreparedStatement pstmt = null;
           ResultSet rs = null;
            
              try{
                 con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
          String query = "SELECT  num , grade, title, major, classname, price, content ,userID,  DATE_FORMAT( writeday , '%Y-%m-%d') AS writeday ,  readcnt from rboard order by num DESC";
             
          pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
          rs = pstmt.executeQuery(  );
            
              int perPage = to.getPerPage();
              int skip = ( curPage - 1 ) * perPage;
                  if( skip > 0 ){
                     rs.absolute( skip );
                  }
                  for( int i = 0 ; i < perPage &&  rs.next() ; i++){
                  int num = rs.getInt( "num" );
                  String grade = rs.getString( "grade" );
                  String title = rs.getString( "title" );
                  String major = rs.getString( "major" );
                  String classname = rs.getString( "classname" );
                  String price = rs.getString( "price" );
                  String content = rs.getString( "content" );
                  String writeday = rs.getString( "writeday" );
                  String userID = rs.getString("userID");
                  int readcnt = rs.getInt( "readcnt" );
     
                  BoardRTO data = new BoardRTO();
                  data.setNum( num );
                  data.setgrade( grade );
                  data.setTitle( title );
                  data.setMajor( major );
                  data.setclassname( classname );   
                  data.setPrice( price );
                  data.setContent( content );
                  data.setWriteday( writeday );
                  data.setReadcnt( readcnt );
                  data.setuserID(userID);
                  list.add( data );
               }
                  
                  to.setRSList( list ); 
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