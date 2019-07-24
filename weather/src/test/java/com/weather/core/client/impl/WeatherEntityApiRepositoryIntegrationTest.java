package com.weather.core.client.impl;

import static org.junit.Assert.assertNotNull;

import com.weather.WeatherApplication;
import com.weather.core.client.WeatherClient;
import com.weather.core.entity.FullWeatherEntity;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WeatherApplication.class)
public class WeatherEntityApiRepositoryIntegrationTest {

  @Autowired WeatherClient weatherClient;

  private static final int CITY_ID = 625144;

  @Test
  public void testThatGetWeatherShouldReturnWeather() {
    final Optional<FullWeatherEntity> response = weatherClient.get(CITY_ID);

    assertNotNull("Response should not be null", response);
  }
}
