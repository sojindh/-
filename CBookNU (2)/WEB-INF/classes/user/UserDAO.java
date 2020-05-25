package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import java.sql.DriverManager;

public class UserDAO {
	String jdbc_driver = "com.mysql.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://127.0.0.1/jspdb";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public UserDAO() {
		try {
			Class.forName(jdbc_driver);
			con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public int login(String userID, String userPassword) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			String SQL="SELECT userPassword FROM user WHERE userID LIKE ?";	
		
			pstmt=con.prepareStatement(SQL);
			pstmt.setString(1, userID);
			System.out.println(userID);
			rs=pstmt.executeQuery();	
			
			if(rs.next()) {
				if(rs.getString("userPassword").equals(userPassword))
					return 1;
				else
					return 0;
			}
			else
				return -1;//아이디 없
		}catch(Exception e){ 
            e.printStackTrace();
		}
			
			return -2;
		}
}
