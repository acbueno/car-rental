package br.com.acbueno.carrental.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import br.com.acbueno.carrental.command.model.enums.Category;
import br.com.acbueno.carrental.command.model.enums.Type;
import lombok.Data;

@Data
public class CarResponseDTO {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("lincese-plate")
  private String licensePlate;

  @JsonProperty("model")
  private String model;

  @JsonProperty("brand")
  private String brand;

  @JsonProperty("available")
  private boolean available;

  @JsonProperty("year-model")
  private Integer yearModel;

  @JsonProperty("category")
  private Category category;

  @JsonProperty("type")
  private Type type;

}
