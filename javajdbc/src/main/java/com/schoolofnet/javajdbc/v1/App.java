package com.schoolofnet.javajdbc.v1;

import java.sql.SQLException;
import java.util.List;

import com.schoolofnet.javajdbc.v1.models.Users;
import com.schoolofnet.javajdbc.v1.models.UsersDAO;

public class App 
{
    public static void main( String[] args ) {
    	if (new ConnectionFactoryOld().getConnection() != null) {
    		System.out.println("Connected");
    	}
    	if (ConnectionFactory.getConnection() != null) {
    		System.out.println("Connected");
    	}
    	
    	try {
//    		String query = "SELECT * FROM users WHERE id = ? AND name = ?";
//    		PreparedStatement é usado para DML enquanto que o Statement para DDL
//    		PreparedStatement preparedStatement = ConnectionFactory.getConnection().prepareStatement(query);
//			preparedStatement.setInt(1, 1);
//			preparedStatement.setString(2, "Whenes");
//    		preparedStatement.executeQuery();
    		
//    		String query = "SELECT * FROM users";
//    		PreparedStatement preparedStatement = ConnectionFactory.getConnection().prepareStatement(query);
//    		
//    		ResultSet rs = preparedStatement.executeQuery();
//    		while (rs.next()) {
//    			System.out.println(rs.getInt("id"));
//    			System.out.println(rs.getString("name"));
//    		}
    		
//    		String query = "SELECT * FROM users";
//    		PreparedStatement preparedStatement = ConnectionFactory.getConnection().prepareStatement(query);
//    		
//    		ResultSet rs = preparedStatement.executeQuery();
//    		List<Users> users = new ArrayList<Users>();
//    		
//    		while (rs.next()) {
//    			Users user = new Users(rs.getInt("id"), rs.getString("name"));
//    			users.add(user);
//    			System.out.println(user.getName());
//    		}
    		
    		UsersDAO usersDao = new UsersDAO();
    		List<Users> users = usersDao.findAll();
    		for (Users user : users) {
    			System.out.println(user.getId() + " - " + user.getName());
    		}
    		
    		System.out.println(usersDao.findById(1).getName());
    		
//    		System.out.println(usersDao.insert(new Users(9, "test9")));
    		System.out.println(usersDao.insert(new Users(null, "test10")));
    		
    		System.out.println(usersDao.remove(new Users(9, null)).toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
