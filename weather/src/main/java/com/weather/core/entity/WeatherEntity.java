package com.weather.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.weather.core.repository.deserialozer.WeatherJsonDeserializer;
import java.io.Serializable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = WeatherJsonDeserializer.class)
public class WeatherEntity implements Serializable {

  private static final long serialVersionUID = -3423199787174770106L;

  @JsonProperty("name")
  private String name;

  @JsonProperty("temp_min")
  private String tempMin;

  @JsonProperty("temp_max")
  private String tempMax;

  @JsonProperty("speed")
  private String speed;

  @JsonProperty("rain")
  private String rain;

  @JsonProperty("snow")
  private String snow;

  @JsonProperty("description")
  private String description;
}