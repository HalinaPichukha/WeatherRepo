package com.weather.core.repository.impl;

import com.weather.core.entity.WeatherEntity;
import com.weather.core.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class WeatherApiRepository implements WeatherRepository {

  private static final String CITY = "Minsk,by";
  private static final String TYPE = "like";
  private static final String APPID = "dc313339c6815c0e796bc8940d427d2e";
  private static final String RESOURCE_URL =
      "http://api.openweathermap.org/data/2.5/find?q={CITY}&TYPE={TYPE}&APPID={APPID}";

  private RestTemplate restTemplate;

  @Autowired
  WeatherApiRepository(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Override
  public WeatherEntity getWeather() {
    ResponseEntity<WeatherEntity> entity =
        restTemplate.getForEntity(RESOURCE_URL, WeatherEntity.class, CITY, TYPE, APPID);

    return entity.getBody();
  }
}