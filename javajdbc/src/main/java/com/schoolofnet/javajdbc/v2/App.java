package com.schoolofnet.javajdbc.v2;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class App {
	public static void main(String[] args) throws SQLException {
		MovieDAO movieDAO = new MovieDAO();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("--MENU--");
		System.out.println("1 - List movie");
		System.out.println("2 - Create movie");
		System.out.println("3 - Update movie");
		System.out.println("4 - Delete movie");
		System.out.println("--MENU--");
		
		int choice = scanner.nextInt();
		
		switch (choice) {
		case 1:
			List<Movie> movies = movieDAO.findAll();
			for (Movie movie : movies) {
				System.out.println(movie.toString());
			}
			break;
		case 2:
			System.out.println("Enter name:");
			movieDAO.insert(new Movie(scanner.next()));
			break;
		case 3:
			System.out.println("Enter id");
			Integer id = scanner.nextInt();
			Movie movieExists = movieDAO.findById(id);
			
			if (movieExists != null) {
				System.out.println("Enter new movie name");
				String name = scanner.next();
				Movie movieNew = new Movie(movieExists.getId(), name);
				movieDAO.update(movieExists, movieNew);
			} else {
				System.out.println("Does not exists");
			}
			break;
		case 4:
			System.out.println("Enter id");
			Integer idDelete = scanner.nextInt();			
			
			Movie movieExist = movieDAO.findById(idDelete);
			if (movieExist != null) {
				movieDAO.delete(new Movie(idDelete, null));				
			} else {
				System.out.println("Does not exists");
			}
			break;

		default:
			System.out.println("Invalid option");
			break;
		}
	}
}
