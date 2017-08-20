package com.reciperex.storage.entity;

import java.sql.SQLException;
import java.time.LocalDate;

import com.reciperex.model.Comment;

public interface CommentService {

	public int insertNewComment(Comment comment, Integer userId);
	
	public int updateComment(Comment comment);
	
	public int deleteComment(Integer id) throws SQLException;

	public Comment getCommentByUserIdAndTimestamp(Integer userId, LocalDate timestamp);
	
}
