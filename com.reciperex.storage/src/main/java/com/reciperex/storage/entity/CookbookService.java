package com.reciperex.storage.entity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbutils.QueryRunner;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reciperex.model.User;
import com.reciperex.storage.service.DatabaseConfig;
import com.reciperex.storage.service.DatabaseManager;

public class CookbookService {

	DatabaseConfig config = new DatabaseConfig();
//	QueryRunner queryRunner = new QueryRunner();
//	ObjectMapper mapper = new ObjectMapper();
//	JSONParser parser = new JSONParser();
	DatabaseManager manager = new DatabaseManager();
	
	Connection conn = null;
	Statement stmt = null;
	Statement pstmt = null;
	String sql = null;
	
	public CookbookService(){
		
	}
	
	
	public int insertNewUser(User user){
		
		String result = null;
		conn = manager.getConnection();
		int r = 0;
		sql = "INSERT INTO user (username, password, email, pantryId, "
				+ "bio, firstName, lastName, city, state, country, gender) "
				+ "VALUES (\"" + user.getUsername() + "\",\"" + user.getPassword() + "\",\"" + user.getEmail() 
				+ "\"," + user.getPantryId() + ",\"" + user.getBio() + "\",\"" + user.getFirstName() 
				+ "\",\"" + user.getLastName() + "\",\"" + user.getCity() + "\",\"" + user.getState() 
				+ "\",\"" + user.getCountry() + "\",\"" + user.getGender() + "\");";
		
		try {
			stmt = conn.createStatement();
			r = stmt.executeUpdate(sql);
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
}
