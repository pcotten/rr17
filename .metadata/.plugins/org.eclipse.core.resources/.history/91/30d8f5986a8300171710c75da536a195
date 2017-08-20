package com.reciperex.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recipe {
	
	private Integer id;
	private String title;
	private String description;
	private Integer owner;
	private String attributedTo;
	private Map<String, String> ingredients;  // name, quantity
	private List<Integer> instructions;
	private Integer numberOfServings;
	private Integer ovenTemp;
	private List<Integer> images;
	private String servingSize;
	private String cookTime;
	private String prepTime;

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
		this.instructions = new ArrayList<Integer>();
		this.images = new ArrayList<Integer>();
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

	public List<Integer> getInstructions() {
		return instructions;
	}
	public void setInstructions(List<Integer> instructions) {
		this.instructions = instructions;
	}
	
	public List<Integer> getImages() {
		return images;
	}
	public void setImages(List<Integer> images) {
		this.images = images;
	}


	public Integer getOwner() {
		return owner;
	}

	public void setOwner(Integer owner) {
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
	
	
	
	
}
