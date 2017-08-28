package com.reciperex.model;

import java.util.ArrayList;
import java.util.List;

public class Ingredient {

	private Integer id;
	private String name;
	private String description;
	private Float quantity;
	private String quantityUnit;
	private List<Integer> categories;
	
	public Ingredient(){
		
	}
	
	public Ingredient(String name, String description) {
		super();
		this.name = name;
		this.description = description;
		this.categories = new ArrayList<Integer>();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}
	
	public String getQuantityUnit() {
		return quantityUnit;
	}

	public void setQuantityUnit(String quantityUnit) {
		this.quantityUnit = quantityUnit;
	}

	public List<Integer> getCategories() {
		return categories;
	}

	public void setCategories(List<Integer> categories) {
		this.categories = categories;
	}
	
}
