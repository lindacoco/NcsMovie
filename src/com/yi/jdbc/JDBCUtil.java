package com.yi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	//외부에서 생성없이 쓸 수 있도록 
   public static void close(PreparedStatement pstmt) {
	   if(pstmt !=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
   }
   public static void close(Statement stmt) {
	   if(stmt !=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
   }

   public static void close(ResultSet rs) {
	   if(rs !=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
   }
   
   public static void close(Connection conn) {
	   if(conn !=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
   }
   
   public static Connection getConnection() throws SQLException {
	   Connection conn =null;
	     String jdbcDriver = "jdbc:apache:commons:dbcp:jhs_movie";
	     conn = DriverManager.getConnection(jdbcDriver);
	     return conn;
   }

}



