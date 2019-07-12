package com.weather.core.client.impl;

import static org.junit.Assert.assertNotNull;

import com.weather.WeatherApplication;
import com.weather.core.entity.FullWeatherEntity;
import com.weather.core.client.WeatherClient;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WeatherApplication.class)
public class WeatherEntityApiRepositoryIntegrationTest {

  @Autowired
  WeatherClient weatherClient;

  @Test
  public void testThatGetWeatherShouldReturnWeather() {
    final Optional<FullWeatherEntity> response = weatherClient.get();

    assertNotNull("Response should not be null", response);
  }
}