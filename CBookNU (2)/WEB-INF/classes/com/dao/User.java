package com.dao;

import java.util.ArrayList;

import com.entity.BoardFBDTO;
import com.entity.BoardReplyDTO;
import com.entity.PageTO;
import com.entity.UTO;
import java.sql.*;

public class User {
   String jdbc_driver = "com.mysql.jdbc.Driver";
   String jdbc_url = "jdbc:mysql://127.0.0.1/jspdb";
   Connection con = null;

      public User(){
         try{
            Class.forName(jdbc_driver);
            con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
         }catch(Exception e){ e.printStackTrace();}
      }
      public ArrayList<UTO> list(){
         ArrayList<UTO> list = new ArrayList<UTO>();
         PreparedStatement pstmt = null;
         ResultSet rs = null;
         try{
             	con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
             	String query = "SELECT num, userID , userPassword, userName, userTell from user";
             	pstmt = con.prepareStatement(query);
             	rs = pstmt.executeQuery();

             	while( rs.next()){
             		int num = rs.getInt( "num" );
             		String userID = rs.getString( "userID" );
             		String userPassword = rs.getString( "userPassword" );
             		String userName = rs.getString( "userName" );
             		String userTell = rs.getString( "userTell" );
             		UTO data = new UTO();
             		data.setNum( num );
             		data.setuserID(userID);
             		data.setuserPassword(userPassword);
             		data.setuserName( userName );
             		data.setuserTell( userTell );
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
      
      public void Register(String userID ,String userPassword,String userName,String userTell){

         Connection con = null;
         PreparedStatement pstmt = null;
         
         try{
            con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
            String query ="INSERT into user (num, userID , userPassword, userName, userTell ) values (0,?,?,?,?)";
            pstmt = con.prepareStatement(query);
            pstmt.setString( 1, userID );
            pstmt.setString( 2, userPassword );
            pstmt.setString( 3, userName );
            pstmt.setString( 4, userTell );
            pstmt.executeUpdate();
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
      
      public int login(String userID,String userPassword) {
    	  Connection con = null;
    	  PreparedStatement pstmt = null;
          ResultSet rs = null;
         
  		try {	
  				con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
  				String query="SELECT userPassword from user where userID = ?";	
  				pstmt = con.prepareStatement(query);
  				pstmt.setString(1, userID);
  				rs = pstmt.executeQuery();
  				
  				while(rs.next()){
  					if(rs.getString(1).equals(userPassword))
  						return 1; // 찾음
  					else
  						return 0;// 비번 다름
  				}	
  				return -1;//아이디 없음
  		}
  		catch(Exception e) {
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
  		return -2;
  		}
      
      
      public boolean checkID( String  _userID)   {
          Connection con = null;
          PreparedStatement pstmt = null;
          ResultSet rs = null;
          int count = 4;
             try{
                con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
                String query = "SELECT  count(if(userID='" + _userID +"',0 ,null )) FROM user";
              
                pstmt = con.prepareStatement( query );
                System.out.println(_userID);
                rs = pstmt.executeQuery( );
              
             	if( rs.next()){
             		count = rs.getInt( 1 );
             	}
             	if(count == 0)
             		return true;
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
}