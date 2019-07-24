package com.weather.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@JsonDeserialize(builder = RainDTO.Builder.class)
public class RainDTO {

  @JsonProperty("1h")
  private double oneHoursRain;

  @JsonProperty("3h")
  private double threeHoursRain;

  @JsonPOJOBuilder(withPrefix = "")
  public static final class Builder {}
}
