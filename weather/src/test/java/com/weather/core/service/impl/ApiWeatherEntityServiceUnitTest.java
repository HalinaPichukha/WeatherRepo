package com.weather.core.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.weather.api.dto.FullWeatherDTO;
import com.weather.api.mapper.FullWeatherMapper;
import com.weather.core.client.WeatherClient;
import com.weather.core.entity.FullWeatherEntity;
import com.weather.core.entity.MainEntity;
import com.weather.core.entity.RainEntity;
import com.weather.core.entity.SnowEntity;
import com.weather.core.entity.SysEntity;
import com.weather.core.entity.WeatherEntity;
import com.weather.core.entity.WindEntity;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class ApiWeatherEntityServiceUnitTest {

  private FullWeatherEntity weatherEntity;
  private FullWeatherDTO weatherDTO;

  @Mock
  private WeatherClient weatherClient = mock(WeatherClient.class);

  @Mock
  private FullWeatherMapper weatherMapper = mock(FullWeatherMapper.class);

  @InjectMocks
  private ApiWeatherService apiWeatherService = new ApiWeatherService(
      weatherClient, weatherMapper
  );

  @Before
  public void init() {
    weatherEntity = FullWeatherEntity.builder()
        .name("Test")
        .id(1)
        .weather(List.of(WeatherEntity.builder().main("main").description("description").build()))
        .main(MainEntity.builder().temp(0.2).temp_min(0.1).temp_max(0.3).build())
        .wind(WindEntity.builder().speed(0.0).build())
        .sys(SysEntity.builder().country("Country").sunrise(1).sunset(2).build())
        .rain(RainEntity.builder().oneHoursRain(0.0).threeHoursRain(0.1).build())
        .snow(SnowEntity.builder().oneHoursSnow(0.0).oneHoursSnow(0.1).build())
        .build();

    weatherDTO = FullWeatherDTO.builder()
        .name("Test")
        .id(1)
        .weather(List.of(WeatherEntity.builder().main("main").description("description").build()))
        .main(MainEntity.builder().temp(0.2).temp_min(0.1).temp_max(0.3).build())
        .wind(WindEntity.builder().speed(0.0).build())
        .sys(SysEntity.builder().country("Country").sunrise(1).sunset(2).build())
        .rain(RainEntity.builder().oneHoursRain(0.0).threeHoursRain(0.1).build())
        .snow(SnowEntity.builder().oneHoursSnow(0.0).oneHoursSnow(0.1).build())
        .build();
  }

  @Test
  public void testThatGetShouldReturnFullWeatherDTO() {

    when(weatherClient.get()).thenReturn(Optional.ofNullable(weatherEntity));
    when(weatherMapper.convertEntityToDto(weatherEntity))
        .thenReturn(weatherDTO);

    assertEquals("Actual and expected results should be the same", weatherDTO,
        apiWeatherService.getFullWeather());
  }
}