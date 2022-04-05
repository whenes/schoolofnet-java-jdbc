package com.schoolofnet.javajdbc.v1.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.schoolofnet.javajdbc.v1.ConnectionFactory;

public class UsersDAO {
	private Connection con = null;
	private PreparedStatement preparedStatement = null;
	
	public UsersDAO () { 
		con = ConnectionFactory.getConnection();
	}
	
	public List<Users> findAll() throws SQLException {
		String query = "SELECT * FROM users";
		
		preparedStatement = con.prepareStatement(query);
		
		ResultSet rs = preparedStatement.executeQuery();
		List<Users> users = new ArrayList<Users>();
		
		while (rs.next()) {
			users.add(new Users(rs.getInt("id"), rs.getString("name")));
		}
		
		return users;
	}
	
	public Users findById(Integer id) throws SQLException {
		String query = "SELECT * FROM users WHERE id = ?";
		
		preparedStatement = con.prepareStatement(query);
		preparedStatement.setInt(1, id);
		
		ResultSet rs = preparedStatement.executeQuery();
		Users user = null;
		
		while (rs.next()) {
			user = new Users(rs.getInt("id"), rs.getString("name"));
		}
		return user;
	}
	
	public Users insert(Users user) throws SQLException {
//		String query = "INSERT INTO users (id, name) VALUES (?, ?)";
		String query = "INSERT INTO users (name) VALUES (?)";
		
		preparedStatement = con.prepareStatement(query);
//		preparedStatement.setInt(1, user.getId());
		preparedStatement.setString(1, user.getName());
		preparedStatement.execute();
		
		return user;
	}
	
	public Users remove(Users user) throws SQLException {
		String query = "DELETE FROM users WHERE id = ?";
		
		preparedStatement = con.prepareStatement(query);
		preparedStatement.setInt(1, user.getId());
		preparedStatement.execute();
		
		return user;
	}
}
