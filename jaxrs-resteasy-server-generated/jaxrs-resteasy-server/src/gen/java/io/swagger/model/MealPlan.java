package io.swagger.model;

import java.util.Objects;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Meal;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2017-02-13T06:27:37.154Z")
public class MealPlan   {
  
  private Long mealPlanId = null;
  private String name = null;
  private List<Meal> meals = new ArrayList<Meal>();

  /**
   **/
  
  @JsonProperty("mealPlanId")
  public Long getMealPlanId() {
    return mealPlanId;
  }
  public void setMealPlanId(Long mealPlanId) {
    this.mealPlanId = mealPlanId;
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
  
  @JsonProperty("meals")
  public List<Meal> getMeals() {
    return meals;
  }
  public void setMeals(List<Meal> meals) {
    this.meals = meals;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MealPlan mealPlan = (MealPlan) o;
    return Objects.equals(mealPlanId, mealPlan.mealPlanId) &&
        Objects.equals(name, mealPlan.name) &&
        Objects.equals(meals, mealPlan.meals);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mealPlanId, name, meals);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MealPlan {\n");
    
    sb.append("    mealPlanId: ").append(toIndentedString(mealPlanId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    meals: ").append(toIndentedString(meals)).append("\n");
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

