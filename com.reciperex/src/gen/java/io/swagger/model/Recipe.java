/*
 * Recipe Rex API
 * Rest services for Recipe Rex web application. 
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Category;
import io.swagger.model.Ingredient;
import io.swagger.model.Instruction;
import java.util.ArrayList;
import java.util.List;

/**
 * Recipe
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-13T06:27:30.917Z")
public class Recipe   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("category")
  private Category category = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("attributorId")
  private Long attributorId = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("servings")
  private Long servings = null;

  @JsonProperty("ovenTemp")
  private Long ovenTemp = null;

  @JsonProperty("instructions")
  private List<Instruction> instructions = new ArrayList<Instruction>();

  @JsonProperty("ingredients")
  private List<Ingredient> ingredients = new ArrayList<Ingredient>();

  @JsonProperty("status")
  private String status = null;

  public Recipe id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @JsonProperty("id")
  @ApiModelProperty(required = true, value = "")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Recipe category(Category category) {
    this.category = category;
    return this;
  }

   /**
   * Get category
   * @return category
  **/
  @JsonProperty("category")
  @ApiModelProperty(value = "")
  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public Recipe name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @JsonProperty("name")
  @ApiModelProperty(required = true, value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Recipe attributorId(Long attributorId) {
    this.attributorId = attributorId;
    return this;
  }

   /**
   * Get attributorId
   * @return attributorId
  **/
  @JsonProperty("attributorId")
  @ApiModelProperty(value = "")
  public Long getAttributorId() {
    return attributorId;
  }

  public void setAttributorId(Long attributorId) {
    this.attributorId = attributorId;
  }

  public Recipe description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @JsonProperty("description")
  @ApiModelProperty(value = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Recipe servings(Long servings) {
    this.servings = servings;
    return this;
  }

   /**
   * Get servings
   * @return servings
  **/
  @JsonProperty("servings")
  @ApiModelProperty(value = "")
  public Long getServings() {
    return servings;
  }

  public void setServings(Long servings) {
    this.servings = servings;
  }

  public Recipe ovenTemp(Long ovenTemp) {
    this.ovenTemp = ovenTemp;
    return this;
  }

   /**
   * Get ovenTemp
   * @return ovenTemp
  **/
  @JsonProperty("ovenTemp")
  @ApiModelProperty(value = "")
  public Long getOvenTemp() {
    return ovenTemp;
  }

  public void setOvenTemp(Long ovenTemp) {
    this.ovenTemp = ovenTemp;
  }

  public Recipe instructions(List<Instruction> instructions) {
    this.instructions = instructions;
    return this;
  }

  public Recipe addInstructionsItem(Instruction instructionsItem) {
    this.instructions.add(instructionsItem);
    return this;
  }

   /**
   * Get instructions
   * @return instructions
  **/
  @JsonProperty("instructions")
  @ApiModelProperty(value = "")
  public List<Instruction> getInstructions() {
    return instructions;
  }

  public void setInstructions(List<Instruction> instructions) {
    this.instructions = instructions;
  }

  public Recipe ingredients(List<Ingredient> ingredients) {
    this.ingredients = ingredients;
    return this;
  }

  public Recipe addIngredientsItem(Ingredient ingredientsItem) {
    this.ingredients.add(ingredientsItem);
    return this;
  }

   /**
   * Get ingredients
   * @return ingredients
  **/
  @JsonProperty("ingredients")
  @ApiModelProperty(value = "")
  public List<Ingredient> getIngredients() {
    return ingredients;
  }

  public void setIngredients(List<Ingredient> ingredients) {
    this.ingredients = ingredients;
  }

  public Recipe status(String status) {
    this.status = status;
    return this;
  }

   /**
   * pet status in the store
   * @return status
  **/
  @JsonProperty("status")
  @ApiModelProperty(value = "pet status in the store")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Recipe recipe = (Recipe) o;
    return Objects.equals(this.id, recipe.id) &&
        Objects.equals(this.category, recipe.category) &&
        Objects.equals(this.name, recipe.name) &&
        Objects.equals(this.attributorId, recipe.attributorId) &&
        Objects.equals(this.description, recipe.description) &&
        Objects.equals(this.servings, recipe.servings) &&
        Objects.equals(this.ovenTemp, recipe.ovenTemp) &&
        Objects.equals(this.instructions, recipe.instructions) &&
        Objects.equals(this.ingredients, recipe.ingredients) &&
        Objects.equals(this.status, recipe.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, category, name, attributorId, description, servings, ovenTemp, instructions, ingredients, status);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Recipe {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    attributorId: ").append(toIndentedString(attributorId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    servings: ").append(toIndentedString(servings)).append("\n");
    sb.append("    ovenTemp: ").append(toIndentedString(ovenTemp)).append("\n");
    sb.append("    instructions: ").append(toIndentedString(instructions)).append("\n");
    sb.append("    ingredients: ").append(toIndentedString(ingredients)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

