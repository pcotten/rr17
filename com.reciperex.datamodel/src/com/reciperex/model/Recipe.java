package com.reciperex.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recipe {
	
	private Integer id;
	private String title;
	private String description;
	private String owner;  // username of user acct that created recipe
	private String attributedTo;
	private Integer numberOfServings;
	private Integer ovenTemp;
	private String servingSize;
	private String cookTime;
	private String prepTime;
	private Integer rating;
	private Date lastPrepared;
	
	private Map<String, String> ingredients;  // name, quantity
	private Map<Integer, String> instructions; // orderIndex, text
	private List<String> images;
	private List<String> categories;

	public Recipe(){
		init();
	}
	
	public Recipe(String title) {
		super();
		init();
		this.title = title;
	}
	
	public void init(){
		this.ingredients = new HashMap<String, String>();
		this.instructions = new HashMap<Integer, String>();
		this.images = new ArrayList<String>();
		this.categories = new ArrayList<String>();
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Integer getServings() {
		return numberOfServings;
	}
	public void setServings(Integer servings) {
		this.numberOfServings = servings;
	}
	
	public Integer getOvenTemp() {
		return ovenTemp;
	}
	public void setOvenTemp(Integer ovenTemp) {
		this.ovenTemp = ovenTemp;
	}
	
	public Map<String, String> getIngredients() {
		return ingredients;
	}
	public void setIngredients(Map<String, String> ingredients) {
		this.ingredients = ingredients;
	}

	public Map<Integer, String> getInstructions() {
		return instructions;
	}
	public void setInstructions(Map<Integer, String> instructions) {
		this.instructions = instructions;
	}
	
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}


	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getAttributedTo() {
		return attributedTo;
	}

	public void setAttributedTo(String attributedTo) {
		this.attributedTo = attributedTo;
	}

	public Integer getNumberOfServings() {
		return numberOfServings;
	}

	public void setNumberOfServings(Integer numberOfServings) {
		this.numberOfServings = numberOfServings;
	}

	public String getServingSize() {
		return servingSize;
	}

	public void setServingSize(String servingSize) {
		this.servingSize = servingSize;
	}

	public String getCookTime() {
		return cookTime;
	}

	public void setCookTime(String cookTime) {
		this.cookTime = cookTime;
	}

	public String getPrepTime() {
		return prepTime;
	}

	public void setPrepTime(String prepTime) {
		this.prepTime = prepTime;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Date getLastPrepared() {
		return lastPrepared;
	}

	public void setLastPrepared(Date lastPrepared) {
		this.lastPrepared = lastPrepared;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
	
	
	
	
}
