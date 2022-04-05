package com.schoolofnet.javajdbc.v2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	public MovieDAO() {
		connection = new ConnectionFactory().getConnection();
	}

	public List<Movie> findAll() throws SQLException {
		String query = "SELECT * FROM movie";
		List<Movie> movies = new ArrayList<Movie>();
		preparedStatement = connection.prepareStatement(query);
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()) {
			movies.add(new Movie(rs.getInt("id"), rs.getString("name")));
		}
		return movies;
	}
	
	public void insert(Movie movie) throws SQLException {
		String query = "INSERT INTO movie (name) values (?)";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, movie.getName());
		preparedStatement.execute();
	}
	
	public void update(Movie movieOld, Movie movieNew) throws SQLException {
		String query = "UPDATE movie SET name = ? WHERE id = ?";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, movieNew.getName());
		preparedStatement.setInt(2, movieNew.getId());
		preparedStatement.execute();
	}
	
	public Movie findById(Integer id) throws SQLException {
		String query = "SELECT * FROM movie WHERE id = ?";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()) {
			return new Movie(rs.getInt("id"), rs.getString("name"));
		}
		return null;
	}
	
	public void delete(Movie movie) throws SQLException {
		String query = "DELETE FROM movie WHERE id = ?";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, movie.getId());
		preparedStatement.execute();		
	}
}
