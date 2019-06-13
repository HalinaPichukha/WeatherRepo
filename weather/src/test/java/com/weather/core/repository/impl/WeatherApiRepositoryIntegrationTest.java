package com.weather.core.repository.impl;

import static org.junit.Assert.assertNotNull;

import com.weather.WeatherApplication;
import com.weather.core.entity.WeatherEntity;
import com.weather.core.repository.WeatherRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WeatherApplication.class)
public class WeatherApiRepositoryIntegrationTest {

  @Autowired
  WeatherRepository weatherRepository;

  @Test
  public void getWeatherShouldReturnWeather() {
    final WeatherEntity response = weatherRepository.getWeather();

    assertNotNull("Response should not be null", response);
  }
}