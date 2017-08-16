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


package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Instruction
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-02-13T06:28:01.512Z")
public class Instruction {
  @SerializedName("id")
  private Long id = null;

  @SerializedName("instructionOrderIndex")
  private Long instructionOrderIndex = null;

  @SerializedName("instructionText")
  private String instructionText = null;

  public Instruction id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "null", value = "")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Instruction instructionOrderIndex(Long instructionOrderIndex) {
    this.instructionOrderIndex = instructionOrderIndex;
    return this;
  }

   /**
   * Get instructionOrderIndex
   * @return instructionOrderIndex
  **/
  @ApiModelProperty(example = "null", value = "")
  public Long getInstructionOrderIndex() {
    return instructionOrderIndex;
  }

  public void setInstructionOrderIndex(Long instructionOrderIndex) {
    this.instructionOrderIndex = instructionOrderIndex;
  }

  public Instruction instructionText(String instructionText) {
    this.instructionText = instructionText;
    return this;
  }

   /**
   * Get instructionText
   * @return instructionText
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getInstructionText() {
    return instructionText;
  }

  public void setInstructionText(String instructionText) {
    this.instructionText = instructionText;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Instruction instruction = (Instruction) o;
    return Objects.equals(this.id, instruction.id) &&
        Objects.equals(this.instructionOrderIndex, instruction.instructionOrderIndex) &&
        Objects.equals(this.instructionText, instruction.instructionText);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, instructionOrderIndex, instructionText);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Instruction {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    instructionOrderIndex: ").append(toIndentedString(instructionOrderIndex)).append("\n");
    sb.append("    instructionText: ").append(toIndentedString(instructionText)).append("\n");
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

