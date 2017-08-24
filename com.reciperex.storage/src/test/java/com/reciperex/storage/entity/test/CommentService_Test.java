package com.reciperex.storage.entity.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import com.reciperex.model.Comment;
import com.reciperex.model.Recipe;
import com.reciperex.model.User;
import com.reciperex.storage.entity.CommentService;
import com.reciperex.storage.entity.RecipeService;
import com.reciperex.storage.entity.UserService;
import com.reciperex.storage.entity.impl.CommentServiceImpl;
import com.reciperex.storage.entity.impl.RecipeServiceImpl;
import com.reciperex.storage.entity.impl.UserServiceImpl;
import com.reciperex.storage.service.DatabaseManager;

public class CommentService_Test {

	DatabaseManager manager;
	User user;
	UserService userService = new UserServiceImpl();
	Recipe recipe;
	RecipeService recipeService = new RecipeServiceImpl();
	LocalDate timestamp;
	Comment comment;
	CommentService commentService = new CommentServiceImpl();

	@Before
	public void init(){
		timestamp = LocalDate.now();
		user = userService.getUserByUsername("pcotten");
		recipe = recipeService.getRecipeById(15);
		manager = new DatabaseManager();
		comment = new Comment();
		comment.setText("TestComment");
		comment.setTimestamp(timestamp);
		comment.setUsername(user.getUsername());
		comment.setUserId(user.getId());
		comment.setRecipeId(recipe.getId());
		
	}
	
	@Test
	public void CommentService_CRUD() throws SQLException {
		int result = 0;
		
		// Test create operation
		result = commentService.insertNewComment(comment, user.getId());
		assertTrue(result != 0);
		
		comment = commentService.getCommentById(comment.getId());
		
		// Test update operation
		
		comment.setText("Changed comment text");
		
		result = commentService.updateComment(comment);
		assertTrue(result != -1);
		
		// Test delete operation
		result = -1;
		try {
			result = commentService.deleteComment(comment.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(result != -1);
		
		// Check database for user
		Connection conn = manager.getConnection();
		
		Statement stmt = conn.createStatement();
		String sql = "SELECT COUNT(*) FROM comment WHERE id = " + comment.getId();
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		assertTrue(rs.getInt("COUNT(*)") == 0);
		
	}

}
