package com.reciperex.storage.entity;

import java.sql.SQLException;

import com.reciperex.model.Cookbook;

public interface CookbookService {

	public int insertNewCookbook(Cookbook cookbook, Integer userId);
	
	public int updateCookbook(Cookbook cookbook);
	
	public int deleteCookbook(Integer id) throws SQLException;
	
}
