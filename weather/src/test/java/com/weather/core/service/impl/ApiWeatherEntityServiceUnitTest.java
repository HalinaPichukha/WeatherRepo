package com.weather.core.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.weather.api.dto.CountryInfoDTO;
import com.weather.api.dto.FullWeatherDTO;
import com.weather.api.dto.RainDTO;
import com.weather.api.dto.SnowDTO;
import com.weather.api.dto.TemperatureDTO;
import com.weather.api.dto.WeatherDTO;
import com.weather.api.dto.WindDTO;
import com.weather.api.mapper.FullWeatherMapper;
import com.weather.core.client.WeatherClient;
import com.weather.core.entity.FullWeatherEntity;
import com.weather.core.entity.MainEntity;
import com.weather.core.entity.RainEntity;
import com.weather.core.entity.SnowEntity;
import com.weather.core.entity.SysEntity;
import com.weather.core.entity.WeatherEntity;
import com.weather.core.entity.WindEntity;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class ApiWeatherEntityServiceUnitTest {

  private FullWeatherEntity fullWeatherEntity;
  private FullWeatherDTO fullWeatherDTO;

  private static final int CITY_ID = 625144;
  private static final long SECS = 1563961730;
  private final Date date = new Date(SECS * 1000);

  @Mock private WeatherClient weatherClient = mock(WeatherClient.class);

  @Mock private FullWeatherMapper weatherMapper = mock(FullWeatherMapper.class);

  @InjectMocks
  private ApiWeatherService apiWeatherService = new ApiWeatherService(weatherClient, weatherMapper);

  @Before
  public void init() {
    fullWeatherEntity =
        FullWeatherEntity.builder()
            .name("Test")
            .id(1)
            .weather(
                List.of(WeatherEntity.builder().main("main").description("description").build()))
            .main(MainEntity.builder().temp(0.2).temp_min(0.1).temp_max(0.3).build())
            .wind(WindEntity.builder().speed(0.0).build())
            .sys(SysEntity.builder().country("Country").sunrise(1).sunset(2).build())
            .rain(RainEntity.builder().oneHoursRain(0.0).threeHoursRain(0.1).build())
            .snow(SnowEntity.builder().oneHoursSnow(0.0).oneHoursSnow(0.1).build())
            .build();

    fullWeatherDTO =
        FullWeatherDTO.builder()
            .name("Test")
            .id(1)
            .weather(List.of(WeatherDTO.builder().main("main").description("description").build()))
            .temperature(TemperatureDTO.builder().temp(0.2).temp_min(0.1).temp_max(0.3).build())
            .wind(WindDTO.builder().speed(0.0).build())
            .countryInfo(
                CountryInfoDTO.builder().country("Country").sunrise(date).sunset(date).build())
            .rain(RainDTO.builder().oneHoursRain(0.0).threeHoursRain(0.1).build())
            .snow(SnowDTO.builder().oneHoursSnow(0.0).oneHoursSnow(0.1).build())
            .build();
  }

  @Test
  public void testThatGetShouldReturnFullWeatherDTO() {

    when(weatherClient.get(CITY_ID)).thenReturn(Optional.ofNullable(fullWeatherEntity));
    when(weatherMapper.convertEntityToDto(fullWeatherEntity)).thenReturn(fullWeatherDTO);

    assertEquals(
        "Actual and expected results should be the same",
        fullWeatherDTO,
        apiWeatherService.getFullWeather(CITY_ID));
  }
}
