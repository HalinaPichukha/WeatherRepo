package com.weather.api.dto;

import java.io.Serializable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Setter
@Getter
@ToString
public class WeatherDTO implements Serializable {

  private static final long serialVersionUID = 5962604923215675882L;

  private String name;
  private String tempMin;
  private String tempMax;
  private String speed;
  private String rain;
  private String snow;
  private String description;
}