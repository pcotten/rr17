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
import io.swagger.model.Recipe;
import java.util.ArrayList;
import java.util.List;

/**
 * Meal
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-13T06:27:30.917Z")
public class Meal   {
  @JsonProperty("mealId")
  private Long mealId = null;

  @JsonProperty("mealName")
  private String mealName = null;

  @JsonProperty("recipes")
  private List<Recipe> recipes = new ArrayList<Recipe>();

  public Meal mealId(Long mealId) {
    this.mealId = mealId;
    return this;
  }

   /**
   * Get mealId
   * @return mealId
  **/
  @JsonProperty("mealId")
  @ApiModelProperty(value = "")
  public Long getMealId() {
    return mealId;
  }

  public void setMealId(Long mealId) {
    this.mealId = mealId;
  }

  public Meal mealName(String mealName) {
    this.mealName = mealName;
    return this;
  }

   /**
   * Get mealName
   * @return mealName
  **/
  @JsonProperty("mealName")
  @ApiModelProperty(value = "")
  public String getMealName() {
    return mealName;
  }

  public void setMealName(String mealName) {
    this.mealName = mealName;
  }

  public Meal recipes(List<Recipe> recipes) {
    this.recipes = recipes;
    return this;
  }

  public Meal addRecipesItem(Recipe recipesItem) {
    this.recipes.add(recipesItem);
    return this;
  }

   /**
   * Get recipes
   * @return recipes
  **/
  @JsonProperty("recipes")
  @ApiModelProperty(value = "")
  public List<Recipe> getRecipes() {
    return recipes;
  }

  public void setRecipes(List<Recipe> recipes) {
    this.recipes = recipes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Meal meal = (Meal) o;
    return Objects.equals(this.mealId, meal.mealId) &&
        Objects.equals(this.mealName, meal.mealName) &&
        Objects.equals(this.recipes, meal.recipes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mealId, mealName, recipes);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Meal {\n");
    
    sb.append("    mealId: ").append(toIndentedString(mealId)).append("\n");
    sb.append("    mealName: ").append(toIndentedString(mealName)).append("\n");
    sb.append("    recipes: ").append(toIndentedString(recipes)).append("\n");
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

