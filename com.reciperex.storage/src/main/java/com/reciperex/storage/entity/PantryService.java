package com.reciperex.storage.entity;

import java.sql.SQLException;

public interface PantryService {

	public String insertNewPantry(String description);
	
	public int updatePantry(Integer id, String description);
	
	public int deletePantry(Integer id) throws SQLException;
	
}
