package com.weather.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder(builderClassName = "Builder", toBuilder = true)
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonDeserialize(builder = SnowDTO.Builder.class)
public class SnowDTO {

  @JsonProperty("1h")
  private double oneHoursSnow;

  @JsonProperty("3h")
  private double threeHoursSnow;

  @JsonPOJOBuilder(withPrefix = "")
  public static final class Builder {
  }
}