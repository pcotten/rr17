package com.reciperex.storage.entity.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reciperex.model.User;
import com.reciperex.storage.entity.ImageService;
import com.reciperex.storage.entity.PantryService;
import com.reciperex.storage.entity.RecipeService;
import com.reciperex.storage.entity.UserService;
import com.reciperex.storage.service.DatabaseConfig;
import com.reciperex.storage.service.DatabaseManager;
import com.reciperex.storage.service.SQLBuilder;

public class UserServiceImpl implements UserService {

	DatabaseConfig config = new DatabaseConfig();
	QueryRunner queryRunner = new QueryRunner();
	ObjectMapper mapper = new ObjectMapper();
	JSONParser parser = new JSONParser();
	DatabaseManager manager = new DatabaseManager();
	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	String sql = null;
	
	public UserServiceImpl(){
		
	}
	
	public int insertNewUser(User user){
		Savepoint savepoint;

		int r = 0;
		
		try {
			
			if (user.getPantryCode() == null){
				PantryService pantryService = new PantryServiceImpl();
				user.setPantryCode(pantryService.insertNewPantry(null));
			}
			
			conn = manager.getConnection();
			savepoint = conn.setSavepoint();
			try {
				user = insertUserEntity(user);
				if (user.getId() != null){
					r = 1;
				}
				if (r != 0){
					System.out.println("User entity " + user.getUsername() + " successfully inserted into database");
				}
				else {
					System.out.println("Unable to complete user insert - failed to insert user entity");
					throw new SQLException();
				}
				
				
				
			} catch (SQLException e) {
				System.out.println("Attempting rollback");
				conn.rollback(savepoint);
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.println("Unable to perform rollback.");
			e1.printStackTrace();
		}
		
		return r;
	}
	
	public User insertUserEntity(User user){

		conn = manager.getConnection();
		int r = 0;
		try {
			pstmt = conn.prepareStatement("INSERT INTO user (username, password, email, bio, "
					+ "firstName, lastName, city, state, country, gender, pantryCode) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getBio());
			pstmt.setString(5, user.getFirstName());
			pstmt.setString(6, user.getLastName());
			pstmt.setString(7, user.getCity());
			pstmt.setString(8, user.getState());
			pstmt.setString(9, user.getCountry());
			pstmt.setString(10, user.getGender().toString());
			pstmt.setString(11, user.getPantryCode());
			
			r = pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()){
				Integer id = Integer.valueOf(rs.getString("GENERATED_KEY"));
				user.setId(id);
			}
			if (r != 0){
				System.out.println("User " + user.getUsername() + " successfully inserted into database");
			}
			else {
				System.out.println("User " + user.getUsername() + " not created");
			}
			
		} catch (SQLException e) {
			System.out.println("Unable to insert " + user.getId() + " into database");
			e.printStackTrace();
		}

		return user;
	}
	
	public int updateUser(User user){
		//TODO
		return 0;
	}
	
	public int deleteUser(Integer id) throws SQLException{

		int result = -1;

		conn = manager.getConnection();
		pstmt = conn.prepareStatement("DELETE FROM user WHERE id = ?");
		pstmt.setInt(1, id);
		result = pstmt.executeUpdate();
		if (result != -1){
			System.out.println("Successfully removed recipe with recipeId " + id);
		}
		else {
			System.out.println("Unable to remove recipe entity with recipeId " + id);
		}
		
		return result;
	}

	
	public User getUserByUsername(String username){
		Map<String, String> constraints = new HashMap<String, String>();
		constraints.put("username", SQLBuilder.toSQLString(username));
		return (User) manager.retrieveSingleEntity(constraints, User.class);
	}
}