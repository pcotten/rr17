package io.swagger.model;

import java.util.Objects;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2017-02-13T06:27:37.154Z")
public class Cookbook   {
  
  private Long userId = null;
  private List<Long> recipeId = new ArrayList<Long>();

  /**
   **/
  
  @JsonProperty("userId")
  public Long getUserId() {
    return userId;
  }
  public void setUserId(Long userId) {
    this.userId = userId;
  }

  /**
   **/
  
  @JsonProperty("recipeId")
  public List<Long> getRecipeId() {
    return recipeId;
  }
  public void setRecipeId(List<Long> recipeId) {
    this.recipeId = recipeId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cookbook cookbook = (Cookbook) o;
    return Objects.equals(userId, cookbook.userId) &&
        Objects.equals(recipeId, cookbook.recipeId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, recipeId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Cookbook {\n");
    
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    recipeId: ").append(toIndentedString(recipeId)).append("\n");
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

