package com.reciperex.storage.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.reciperex.model.Recipe;
import com.reciperex.model.User;
import com.reciperex.service.IdService;

public class DatabaseManagerOLD {

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3307/recipe_rex_db";
	
	static final String USER = "root";
	static final String PASS = "Xander@932";
	
	Connection conn = null;
	Statement stmt = null;
	Statement pstmt = null;
	
	public DatabaseManagerOLD(){
		init();
	}
	 
	private void init(){
		 try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	 }
	
	public Integer queryMaxIdNumber(String table){
		Integer maxId = null;
		try{
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			stmt = conn.createStatement();
			
			String sql = "SELECT MAX(id) FROM " + table + ";";
			ResultSet result = stmt.executeQuery(sql) ;
			while (result.next()){
				maxId = result.getInt(1);
			}
		}
		catch (SQLException se){
			se.printStackTrace();
		}
		finally {
			try {
				cleanup();
			}
			catch (SQLException e){
				e.printStackTrace();
			} 
		}
		return maxId;
	}
	 
	public List<User> queryUsers(String field, String operator, String value){
		List<User> usersList = new ArrayList<User>();
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			stmt = conn.createStatement();
			
			String sql = "SELECT * FROM user WHERE " + field + operator + value + ";";
			System.out.println("executing : " + sql);
			ResultSet result = stmt.executeQuery(sql);
			
			while (result.next()){
				User user = new User(result.getString("firstName"), result.getString("lastName"),
						result.getString("email"), result.getString("username"), result.getString("password"));
				user.setId(result.getInt("id"));
				usersList.add(user);
				result.last();
				System.out.println("Returned " + result.getRow() + " user(s).");
			}
		}
		catch (SQLException se){
			se.printStackTrace();
		}
		finally {
			try {
				cleanup();
			}
			catch (SQLException e){
				e.printStackTrace();
			}
		}
		
		return usersList;
	}
	
	public List<Recipe> queryRecipe(String field, String operator, String value){
		List<Recipe> recipeList = new ArrayList<Recipe>();
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			stmt = conn.createStatement();
			
			String sql = "SELECT * FROM recipe WHERE " + field + operator + value + ";";
			System.out.println("executing : " + sql);
			ResultSet result = stmt.executeQuery(sql);
			
			while (result.next()){
				Recipe recipe = new Recipe(result.getString("name"));
				recipe.setId(result.getInt("id"));
				recipeList.add(recipe);
				result.last();
				System.out.println("Returned " + result.getRow() + " user(s).");
			}
		}
		catch (SQLException se){
			se.printStackTrace();
		}
		finally {
			try {
				cleanup();
			}
			catch (SQLException e){
				e.printStackTrace();
			}
		}
		
		return recipeList;
	}
	
	public void addToDatabase(Object entry){
		try {
			String sql= null;
			String type = null;
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			stmt = conn.createStatement();

			sql = SQLBuilder.insertModel(entry);
			System.out.println("executing: " + sql);
			int rows = stmt.executeUpdate(sql);
			if (rows > 0){
				type = entry.getClass().toString();
				type = type.substring(type.toString().lastIndexOf(".") + 1);
				System.out.println("New " + type + " added to database.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		 finally {
				try {
					cleanup();
				}
				catch (SQLException e){
					e.printStackTrace();
					
				}
			}
	 }
	
//	public void addUser(User user){
//		try {
//			conn = DriverManager.getConnection(DB_URL, USER, PASS);
//			
//			stmt = conn.createStatement();
//			String sql = SQLBuilder.insertModel(user);
//			System.out.println("executing: " + sql);
//			int rows = stmt.executeUpdate(sql);
//			if (rows > 0){
//				System.out.println("User " + user.getUsername() + " added to database.");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			try {
//				conn.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//		}
//		 finally {
//				try {
//					cleanup();
//				}
//				catch (SQLException e){
//					e.printStackTrace();
//					
//				}
//			}
//	 }
	 
//	 public void deleteUser(User user){
//		try {
//			conn = DriverManager.getConnection(DB_URL, USER, PASS);
//				
//			stmt = conn.createStatement();
//			
//			String sql = "DELETE FROM user WHERE username=" + "'" + user.getUsername() + "'";
//			System.out.println("executing: " + sql);
//			int rows = stmt.executeUpdate(sql);
//			if (rows > 0){
//				System.out.println("User " + user.getUsername() + " removed from database");
//			}
//		 }
//	 	 catch (SQLException e) {
//			e.printStackTrace();
//			try {
//				conn.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//	 	 }
//		finally {
//			try {
//				cleanup();
//			}
//			catch (SQLException e){
//				e.printStackTrace();
//			}
//		}
//	 }
	 
	 public void deleteModel(String table, Integer id){
			try {
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
					
				stmt = conn.createStatement();
				
				String sql = "DELETE FROM " + table + " WHERE id=" + id + ";";
				System.out.println("executing: " + sql);
				int rows = stmt.executeUpdate(sql);
				if (rows > 0){
					System.out.println( table + " with id " + id + " removed from database");
				}
			 }
		 	 catch (SQLException e) {
				e.printStackTrace();
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		 	 }
			 finally {
				try {
					cleanup();
				}
				catch (SQLException e){
					e.printStackTrace();
				}
			}
		 }
	 
	 public void deleteUser(Integer userId){
			try {
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
					
				stmt = conn.createStatement();
				
				String sql = "DELETE FROM user WHERE id=" + '"' + userId + '"';
				System.out.println("executing: " + sql);
				int rows = stmt.executeUpdate(sql);
				if (rows > 0){
					System.out.println("User with id " + userId + " removed from database");
				}
			 }
		 	 catch (SQLException e) {
				e.printStackTrace();
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		 	 }
			 finally {
				try {
					cleanup();
				}
				catch (SQLException e){
					e.printStackTrace();
				}
			}
		 }
	 
	 public void testConnection(){
		 try {
			 
			 System.out.println("Connecting to database...");
			 conn = DriverManager.getConnection(DB_URL, USER, PASS);
			 
			 System.out.println("Creating a statement...");
			 stmt = conn.createStatement();
			 String sql = "SELECT id, firstName, lastName FROM user";
			 ResultSet rs = stmt.executeQuery(sql);
			 
			 while (rs.next()){
				 int id = rs.getInt("id");
				 String firstName = rs.getString("firstName");
				 String lastName = rs.getString("lastName");
				 
				 System.out.println("id : " + id);
				 System.out.println("firstName : " + firstName);
				 System.out.println("lastName : " + lastName); 
			 }
			 
			 rs.close();
			 cleanup();
			 
		 }
		 catch (SQLException se){
			 se.printStackTrace();
		 }
		 catch (Exception e){
			 e.printStackTrace();
		 }
		 finally {
			 try {
				cleanup();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 }
	 }

	private void cleanup() throws SQLException {
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException se) {
				// do nothing
			}
		 if (conn != null){
			 try {
				 conn.close();
			 }
			 catch (SQLException se) {
				 se.printStackTrace();
			 }
		 }
	}
}