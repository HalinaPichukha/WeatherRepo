package com.weather.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.weather.core.entity.MainEntity;
import com.weather.core.entity.RainEntity;
import com.weather.core.entity.SnowEntity;
import com.weather.core.entity.SysEntity;
import com.weather.core.entity.WeatherEntity;
import com.weather.core.entity.WindEntity;
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
  private MainEntity main;
  private WindEntity wind;
  private SysEntity sys;
  private RainEntity rain;
  private SnowEntity snow;

  @JsonPOJOBuilder(withPrefix = "")
  public static final class Builder {

  }
}