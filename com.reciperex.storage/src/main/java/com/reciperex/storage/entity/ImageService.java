package com.reciperex.storage.entity;

import java.sql.SQLException;

import com.reciperex.model.Image;

public interface ImageService {

	public int insertNewImage(Image image);
	
	public int updateImage(Image image);
	
	public int deleteImage(Integer id) throws SQLException;
	
}
