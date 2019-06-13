package com.weather.core.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.weather.api.dto.WeatherDTO;
import com.weather.api.mapper.WeatherMapper;
import com.weather.core.entity.WeatherEntity;
import com.weather.core.repository.WeatherRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class ApiWeatherServiceUnitTest {

  @Mock
  private WeatherRepository weatherRepository = mock(WeatherRepository.class);

  @Mock
  private WeatherMapper weatherMapper = mock(WeatherMapper.class);

  @InjectMocks
  private ApiWeatherService apiWeatherService = new ApiWeatherService(
      weatherRepository, weatherMapper
  );

  private WeatherEntity weatherEntity;
  private WeatherDTO expectedWeatherDTO;

  @Before
  public void init() {
    weatherEntity = WeatherEntity.builder()
        .name("Test")
        .tempMin("0")
        .tempMax("1")
        .speed("5")
        .rain("no")
        .snow("yes")
        .description("description")
        .build();

    expectedWeatherDTO = WeatherDTO.builder()
        .name("Test")
        .tempMin("0")
        .tempMax("1")
        .speed("5")
        .rain("no")
        .snow("yes")
        .description("description")
        .build();
  }

  @Test
  public void testGetWeather() {
    when(weatherRepository.getWeather()).thenReturn(weatherEntity);
    when(weatherMapper.convertEntityToDto(weatherEntity)).thenReturn(expectedWeatherDTO);

    WeatherDTO actualWeather = apiWeatherService.getWeather();

    assertEquals("Actual and expected results should be the same", expectedWeatherDTO,
        actualWeather);
  }
}