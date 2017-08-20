package com.reciperex.storage.entity;

import java.sql.SQLException;

import com.reciperex.model.Category;

public interface CategoryService {

	public int insertNewCategory(Category category);
	
	public int updateCategory(Category category);
	
	public int deleteCategory(Integer id) throws SQLException;

	public Category getCategoryByName(String name);
	
}
