package com.schoolofnet.javajdbc.v1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static ConnectionFactory instance = new ConnectionFactory();
	private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
	private static final String USER = "root";
	private static final String PASSWORD = "12345678";
	private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	private static final String NEW_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	
	private ConnectionFactory() {
		try {
			Class.forName(NEW_DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private Connection createConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static Connection getConnection() {
		return instance.createConnection();
	}
}
