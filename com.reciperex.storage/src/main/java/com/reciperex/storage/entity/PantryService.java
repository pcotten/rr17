package com.reciperex.storage.entity;

import java.sql.SQLException;

import com.reciperex.model.Pantry;

public interface PantryService {

	public Pantry insertNewPantry(Pantry pantry) throws SQLException;
	
	public int updatePantry(Pantry pantry) throws SQLException;
	
	public int deletePantry(Integer id) throws SQLException;

	public Pantry getPantryById(Integer id);
	
}
