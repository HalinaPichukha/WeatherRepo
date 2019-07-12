package com.weather.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder(builderClassName = "Builder", toBuilder = true)
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonDeserialize(builder = MainDTO.Builder.class)
public class MainDTO {

  private double temp;
  private double temp_min;
  private double temp_max;

  @JsonPOJOBuilder(withPrefix = "")
  public static final class Builder {

  }
}