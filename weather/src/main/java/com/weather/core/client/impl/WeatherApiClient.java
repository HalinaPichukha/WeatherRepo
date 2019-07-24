package com.weather.core.client.impl;

import com.weather.core.client.WeatherClient;
import com.weather.core.entity.FullWeatherEntity;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class WeatherApiClient implements WeatherClient {

//  private static final int CITY_ID = 625144;
  private static final String APPID = "dc313339c6815c0e796bc8940d427d2e";

  private static final String RESOURCE_URL =
      "http://api.openweathermap.org/data/2.5/weather?id={CITY_ID}&appid={APPID}";

  private RestTemplate restTemplate;

  @Autowired
  WeatherApiClient(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Override
  public Optional<FullWeatherEntity> get(long id) {

    ResponseEntity<FullWeatherEntity> weatherEntityResponseEntity =
        restTemplate.getForEntity(RESOURCE_URL, FullWeatherEntity.class, id, APPID);

    return Optional.ofNullable(weatherEntityResponseEntity.getBody());
  }
}