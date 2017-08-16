package com.reciperex.storage.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reciperex.model.User;
import com.reciperex.storage.service.DatabaseConfig;
import com.reciperex.storage.service.DatabaseManager;

public class UserService {

	DatabaseConfig config = new DatabaseConfig();
	QueryRunner queryRunner = new QueryRunner();
	ObjectMapper mapper = new ObjectMapper();
	JSONParser parser = new JSONParser();
	DatabaseManager manager = new DatabaseManager();
	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	String sql = null;
	
	public UserService(){
		
	}
	
	
	public int insertNewUser(User user){
		
		if (user.getPantryCode() == null){
			PantryService pantryService = new PantryService();
			user.setPantryCode(pantryService.createNewPantry());
		}
		
		String result = null;
		conn = manager.getConnection();
		int r = 0;
		try {
		pstmt = conn.prepareStatement("INSERT INTO user (username, password, email, bio, "
				+ "firstName, lastName, city, state, country, gender, pantryCode) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
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
			if (r != 0){
				result = "User " + user.getUsername() + " successfully inserted into database";
			}
			else result = "User " + user.getUsername() + " not created";
			
		} catch (SQLException e) {
			System.out.println("Unable to insert " + user.getId() + " into database");
			e.printStackTrace();
		}
		System.out.println(result);
		return r;
	}
	
	public int deleteUser(Integer id){
		int result = -1;
		Map<String,String> constraints = new HashMap<String, String>();
		constraints.put("id", id.toString());
		result = manager.DeleteEntity("user", constraints);
		return result;
	}
}
