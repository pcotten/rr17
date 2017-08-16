package com.reciperex.model;

public class Image {
	
	private Integer id;
	private String imagePath;
	private Integer recipeId;
	private String imageText;
	
	public Image(){
		
	}
	
	public Image(String imagePath, Integer recipeId, String imageText) {
		super();
		this.imagePath = imagePath;
		this.recipeId = recipeId;
		this.imageText = imageText;
	}
	
	public Integer getImageId() {
		return id;
	}
	public void setImageId(Integer imageId) {
		this.id = imageId;
	}
	
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public Integer getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(Integer recipeId) {
		this.recipeId = recipeId;
	}
	
	public String getImageText() {
		return imageText;
	}
	public void setImageText(String imageText) {
		this.imageText = imageText;
	}
	
	
}
