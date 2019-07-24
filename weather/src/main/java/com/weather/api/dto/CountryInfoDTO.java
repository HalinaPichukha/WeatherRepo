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
@JsonDeserialize(builder = CountryInfoDTO.Builder.class)
public class CountryInfoDTO {

  private String country;
  private long sunrise;
  private long sunset;

  @JsonPOJOBuilder(withPrefix = "")
  public static final class Builder {}
}
