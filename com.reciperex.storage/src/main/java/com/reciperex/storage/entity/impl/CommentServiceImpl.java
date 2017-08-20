package com.reciperex.storage.entity.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reciperex.model.Comment;
import com.reciperex.model.Recipe;
import com.reciperex.model.User;
import com.reciperex.storage.entity.CommentService;
import com.reciperex.storage.service.DatabaseConfig;
import com.reciperex.storage.service.DatabaseManager;

public class CommentServiceImpl implements CommentService {

	DatabaseConfig config = new DatabaseConfig();
//	QueryRunner queryRunner = new QueryRunner();
//	ObjectMapper mapper = new ObjectMapper();
//	JSONParser parser = new JSONParser();
	DatabaseManager manager = new DatabaseManager();
	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	String sql = null;
	
	public CommentServiceImpl(){
		
	}
	
	
	public int insertNewComment(Comment comment, Integer userId){
		Savepoint savepoint;

		int r = 0;
		
		try {
			conn = manager.getConnection();
			savepoint = conn.setSavepoint();
			try {
				comment = insertCommentEntity(comment);
				if (comment.getId() != null){
					r = 1;
				}
				if (r != 0){
					System.out.println("Comment entity successfully inserted into database");
				}
				else {
					System.out.println("Unable to complete comment insert - failed to insert comment entity");
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


	private Comment insertCommentEntity(Comment comment) throws SQLException {
		conn = manager.getConnection();
		int r = 0;
		pstmt = conn.prepareStatement("INSERT INTO comment (text, timestamp, userId, parentId, recipeId)"
				+ "VALUES (?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
		pstmt.setString(1, comment.getText());
		pstmt.setObject(2, comment.getTimestamp());
		pstmt.setInt(3, comment.getUserId());
		if (comment.getParentId() != null){
			pstmt.setInt(4, comment.getParentId());
		}
		else {
			pstmt.setNull(4, java.sql.Types.INTEGER);
		}
		pstmt.setInt(5, comment.getRecipeId());
		r = pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		if (rs.next()){
			Integer id = Integer.valueOf(rs.getString("GENERATED_KEY"));
			comment.setId(id);
		}
		if (r != 0 && comment.getId() != null){
			System.out.println("Comment entity successfully inserted into database");
		}
		else {
			System.out.println("Comment creation failed - unable to insert comment entity");
			throw new SQLException();
		}
		
		return comment;
	}


	public int updateComment(Comment comment) {
		// TODO Auto-generated method stub
		return 0;
	}


	public int deleteComment(Integer id) throws SQLException {
		int result = -1;

		conn = manager.getConnection();
		pstmt = conn.prepareStatement("DELETE FROM comment WHERE id = ?");
		pstmt.setInt(1, id);
		result = pstmt.executeUpdate();
		if (result != -1){
			System.out.println("Successfully removed comment with id " + id);
		}
		else {
			System.out.println("Unable to remove image comment with id " + id);
		}
		
		return result;
	}


	public Comment getCommentByUserIdAndTimestamp(Integer userId, LocalDate timestamp) {
		Map<String, String> constraints = new HashMap<String, String>();
		constraints.put("userId", userId.toString());
		constraints.put("timestamp", timestamp.toString());
		return (Comment) manager.retrieveSingleEntity(constraints, Comment.class);
	}
}
