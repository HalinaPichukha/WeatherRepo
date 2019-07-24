package com.weather.core.entity;

import java.io.Serializable;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class FullWeatherEntity implements Serializable {

  private String name;
  private long id;
  private List<WeatherEntity> weather;
  private MainEntity main;
  private WindEntity wind;
  private SysEntity sys;
  private RainEntity rain;
  private SnowEntity snow;
  private DateEntity dt;
}
