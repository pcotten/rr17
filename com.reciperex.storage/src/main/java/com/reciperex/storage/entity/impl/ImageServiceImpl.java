package com.reciperex.storage.entity.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbutils.QueryRunner;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reciperex.model.Image;
import com.reciperex.storage.entity.ImageService;
import com.reciperex.storage.service.DatabaseConfig;
import com.reciperex.storage.service.DatabaseManager;
import com.reciperex.storage.service.SQLBuilder;

public class ImageServiceImpl implements ImageService{

	DatabaseConfig config = new DatabaseConfig();
//	QueryRunner queryRunner = new QueryRunner();
//	ObjectMapper mapper = new ObjectMapper();
//	JSONParser parser = new JSONParser();
	DatabaseManager manager = new DatabaseManager();
	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	String sql = null;
	
	public ImageServiceImpl(){
		
	}
	
	
	public int insertNewImage(Image image){
		String result = null;
		conn = manager.getConnection();
		int r = 0;
		try {
			pstmt = conn.prepareStatement("INSERT INTO image (imagePath , text, recipeId, userId) "
					+ "VALUES (?, ?, ?, ?);");
			pstmt.setString(1, SQLBuilder.toSQLString(image.getImagePath()));
			pstmt.setString(2, SQLBuilder.toSQLString(image.getImageText()));
			if (image.getRecipeId() != null){
				pstmt.setInt(3, image.getRecipeId());
			}
			else pstmt.setNull(3, java.sql.Types.INTEGER);
			if (image.getUserId() != null){
				pstmt.setInt(4, image.getUserId());
			}
			else pstmt.setNull(4, java.sql.Types.INTEGER);
			r = pstmt.executeUpdate();
			if (r != 0){
				result = "Image at " + image.getImagePath() + " successfully inserted into database";
			}
			else result = "Image not created";
			
		} catch (SQLException e) {
			System.out.println("Unable to insert image into database");
			e.printStackTrace();
		}
		System.out.println(result);
		return r;
	}


	public int updateImage(Image image) {
		// TODO Auto-generated method stub
		return 0;
	}


	public int deleteImage(Integer id) throws SQLException {
		int result = -1;

		conn = manager.getConnection();
		pstmt = conn.prepareStatement("DELETE FROM image WHERE id = ?");
		pstmt.setInt(1, id);
		result = pstmt.executeUpdate();
		if (result != -1){
			System.out.println("Successfully removed image with id " + id);
		}
		else {
			System.out.println("Unable to remove image entity with id " + id);
		}
		
		return result;
	}
	
}
