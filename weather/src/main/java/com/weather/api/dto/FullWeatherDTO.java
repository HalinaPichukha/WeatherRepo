package com.weather.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.weather.core.entity.WeatherEntity;

import java.io.Serializable;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder(builderClassName = "Builder", toBuilder = true)
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonDeserialize(builder = FullWeatherDTO.Builder.class)
public class FullWeatherDTO implements Serializable {

  private String name;
  private long id;
  private List<WeatherEntity> weather;
  private TemperatureDTO temperature;
  private WindDTO wind;
  private CountryInfoDTO countryInfo;
  private RainDTO rain;
  private SnowDTO snow;

  @JsonPOJOBuilder(withPrefix = "")
  public static final class Builder {

  }
}