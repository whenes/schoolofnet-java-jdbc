package com.schoolofnet.javajdbc.v2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DDLCreateDropMain {
	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Loaded");
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load");
			e.printStackTrace();
		}
		
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies?serverTimezone=UTC", "root", "12345678");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (connection == null) {
			System.out.println("Connection failed!");
			return;
		}
		
		String createQuery = "CREATE TABLE IF NOT EXISTS movie (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255) NOT NULL)";
		String dropQuery = "DROP TABLE IF EXISTS movie";
		Statement statement = connection.createStatement();
		statement.executeUpdate(dropQuery);
	}
}
