package cl.lgutierrez.example.app.model;

import java.util.Objects;
import cl.lgutierrez.example.app.model.GetUserDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;
/**
 * GetUsersDto
 */

public class GetUsersDto   {
  @JsonProperty("characters")
  private List<GetUserDto> characters = new ArrayList<GetUserDto>();

  public GetUsersDto characters(List<GetUserDto> characters) {
    this.characters = characters;
    return this;
  }

  public GetUsersDto addCharactersItem(GetUserDto charactersItem) {
    this.characters.add(charactersItem);
    return this;
  }

   /**
   * Get characters
   * @return characters
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public List<GetUserDto> getCharacters() {
    return characters;
  }

  public void setCharacters(List<GetUserDto> characters) {
    this.characters = characters;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetUsersDto getUsersDto = (GetUsersDto) o;
    return Objects.equals(this.characters, getUsersDto.characters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(characters);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetUsersDto {\n");
    
    sb.append("    characters: ").append(toIndentedString(characters)).append("\n");
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

