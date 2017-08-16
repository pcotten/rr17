package io.swagger.model;

import java.util.Objects;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2017-02-13T06:27:37.154Z")
public class Instruction   {
  
  private Long id = null;
  private Long instructionOrderIndex = null;
  private String instructionText = null;

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
  
  @JsonProperty("instructionOrderIndex")
  public Long getInstructionOrderIndex() {
    return instructionOrderIndex;
  }
  public void setInstructionOrderIndex(Long instructionOrderIndex) {
    this.instructionOrderIndex = instructionOrderIndex;
  }

  /**
   **/
  
  @JsonProperty("instructionText")
  public String getInstructionText() {
    return instructionText;
  }
  public void setInstructionText(String instructionText) {
    this.instructionText = instructionText;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Instruction instruction = (Instruction) o;
    return Objects.equals(id, instruction.id) &&
        Objects.equals(instructionOrderIndex, instruction.instructionOrderIndex) &&
        Objects.equals(instructionText, instruction.instructionText);
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

