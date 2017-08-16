package io.swagger.model;

import java.util.Objects;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Category;
import io.swagger.model.Ingredient;
import io.swagger.model.Instruction;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2017-02-13T06:27:37.154Z")
public class Recipe   {
  
  private Long id = null;
  private Category category = null;
  private String name = null;
  private Long attributorId = null;
  private String description = null;
  private Long servings = null;
  private Long ovenTemp = null;
  private List<Instruction> instructions = new ArrayList<Instruction>();
  private List<Ingredient> ingredients = new ArrayList<Ingredient>();
  private String status = null;

  /**
   **/
  
  @JsonProperty("id")
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  /**
   **/
  
  @JsonProperty("category")
  public Category getCategory() {
    return category;
  }
  public void setCategory(Category category) {
    this.category = category;
  }

  /**
   **/
  
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   **/
  
  @JsonProperty("attributorId")
  public Long getAttributorId() {
    return attributorId;
  }
  public void setAttributorId(Long attributorId) {
    this.attributorId = attributorId;
  }

  /**
   **/
  
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   **/
  
  @JsonProperty("servings")
  public Long getServings() {
    return servings;
  }
  public void setServings(Long servings) {
    this.servings = servings;
  }

  /**
   **/
  
  @JsonProperty("ovenTemp")
  public Long getOvenTemp() {
    return ovenTemp;
  }
  public void setOvenTemp(Long ovenTemp) {
    this.ovenTemp = ovenTemp;
  }

  /**
   **/
  
  @JsonProperty("instructions")
  public List<Instruction> getInstructions() {
    return instructions;
  }
  public void setInstructions(List<Instruction> instructions) {
    this.instructions = instructions;
  }

  /**
   **/
  
  @JsonProperty("ingredients")
  public List<Ingredient> getIngredients() {
    return ingredients;
  }
  public void setIngredients(List<Ingredient> ingredients) {
    this.ingredients = ingredients;
  }

  /**
   * pet status in the store
   **/
  
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Recipe recipe = (Recipe) o;
    return Objects.equals(id, recipe.id) &&
        Objects.equals(category, recipe.category) &&
        Objects.equals(name, recipe.name) &&
        Objects.equals(attributorId, recipe.attributorId) &&
        Objects.equals(description, recipe.description) &&
        Objects.equals(servings, recipe.servings) &&
        Objects.equals(ovenTemp, recipe.ovenTemp) &&
        Objects.equals(instructions, recipe.instructions) &&
        Objects.equals(ingredients, recipe.ingredients) &&
        Objects.equals(status, recipe.status);
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

