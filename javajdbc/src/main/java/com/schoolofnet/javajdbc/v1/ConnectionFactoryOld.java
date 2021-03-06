package com.schoolofnet.javajdbc.v1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactoryOld {

	private Connection con = null;
	
	public Connection getConnection() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?useLegacyDatetimeCode=false&timeZone=UTC", "root", "12345678");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.con;
	}
	
	public void closeConnection() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
//	public static void main(String[] args) {
//    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?useLegacyDatetimeCode=false&timeZone=UTC", "root", "12345678");
////    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "12345678");
//    	System.out.println("Connected");
//	}
}
