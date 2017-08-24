package com.reciperex.storage.entity;

import java.sql.SQLException;

import com.reciperex.model.Image;

public interface ImageService {

	public Image insertNewImage(Image image) throws SQLException;
	
	public int updateImage(Image image) throws SQLException;
	
	public int deleteImage(Integer id) throws SQLException;

	public Image getImageById(Integer id);
	
}
