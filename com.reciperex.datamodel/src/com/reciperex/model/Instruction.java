package com.reciperex.model;

public class Instruction {

	private Integer id;
	private Integer orderIndex;
	private String text;
	private Integer recipeId;
	
	public Instruction(){
		
	}
	
	public Instruction(Integer instructionOrderIndex, Integer recipeId) {
		super();
		this.orderIndex = instructionOrderIndex;
		this.recipeId = recipeId;
	}
	
	public Integer getInstructionId() {
		return id;
	}
	public void setInstructionId(Integer instructionId) {
		this.id = instructionId;
	}
	
	public Integer getInstructionOrderIndex() {
		return orderIndex;
	}
	public void setInstructionOrderIndex(Integer instructionOrderIndex) {
		this.orderIndex = instructionOrderIndex;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public Integer getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(Integer recipeId) {
		this.recipeId = recipeId;
	}
	
	
}