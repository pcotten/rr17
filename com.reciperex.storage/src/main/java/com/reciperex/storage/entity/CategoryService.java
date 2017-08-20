package com.reciperex.storage.entity;

import java.sql.SQLException;

public interface CategoryService {

	public int insertNewCategory(String name, String description);
	
	public int updateCategory(Integer id, String name, String description);
	
	public int deleteCategory(Integer id) throws SQLException;
	
}
