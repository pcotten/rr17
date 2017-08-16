package io.swagger.model;

import java.util.Objects;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Recipe;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2017-02-13T06:27:37.154Z")
public class Meal   {
  
  private Long mealId = null;
  private String mealName = null;
  private List<Recipe> recipes = new ArrayList<Recipe>();

  /**
   **/
  
  @JsonProperty("mealId")
  public Long getMealId() {
    return mealId;
  }
  public void setMealId(Long mealId) {
    this.mealId = mealId;
  }

  /**
   **/
  
  @JsonProperty("mealName")
  public String getMealName() {
    return mealName;
  }
  public void setMealName(String mealName) {
    this.mealName = mealName;
  }

  /**
   **/
  
  @JsonProperty("recipes")
  public List<Recipe> getRecipes() {
    return recipes;
  }
  public void setRecipes(List<Recipe> recipes) {
    this.recipes = recipes;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Meal meal = (Meal) o;
    return Objects.equals(mealId, meal.mealId) &&
        Objects.equals(mealName, meal.mealName) &&
        Objects.equals(recipes, meal.recipes);
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

