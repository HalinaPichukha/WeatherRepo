package com.weather.api.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.weather.api.dto.FullWeatherDTO;
import com.weather.core.entity.FullWeatherEntity;
import com.weather.core.entity.MainEntity;
import com.weather.core.entity.RainEntity;
import com.weather.core.entity.SnowEntity;
import com.weather.core.entity.SysEntity;
import com.weather.core.entity.WeatherEntity;
import com.weather.core.entity.WindEntity;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FullWeatherEntityMapperIntegrationTest {

  @Autowired
  private FullWeatherMapper fullWeatherMapper;

  @Test
  public void testNullFullWetherMappedToNullDto() {
    final FullWeatherDTO fullWeatherDTO = fullWeatherMapper.convertEntityToDto(null);

    assertNull("Null fullWeather entity should be converted to null dto", fullWeatherDTO);
  }

  @Test
  public void testThatFullWeatherMapperShouldConvertEntityToDto() {

    FullWeatherEntity fullWeatherEntity = FullWeatherEntity.builder()
        .name("Test")
        .id(1)
        .weather(List.of(WeatherEntity.builder().main("main").description("description").build()))
        .main(MainEntity.builder().temp(0.2).temp_min(0.1).temp_max(0.3).build())
        .wind(WindEntity.builder().speed(0.0).build())
        .sys(SysEntity.builder().country("Country").sunrise(1).sunset(2).build())
        .rain(RainEntity.builder().oneHoursRain(0.0).threeHoursRain(0.1).build())
        .snow(SnowEntity.builder().oneHoursSnow(0.0).oneHoursSnow(0.1).build())
        .build();

    FullWeatherDTO fullWeatherDTO = fullWeatherMapper.convertEntityToDto(fullWeatherEntity);

    assertNotNull("Not null fullWeather can not be null", fullWeatherDTO);
    assertEquals("Converted fullWeather name should match", fullWeatherEntity.getName(),
        fullWeatherDTO.getName());
    assertEquals("Converted fullWeather id should match", fullWeatherEntity.getId(),
        fullWeatherDTO.getId());
    assertEquals("Converted fullWeather weather should match", fullWeatherEntity.getWeather(),
        fullWeatherDTO.getWeather());
    assertEquals("Converted fullWeather main should match", fullWeatherEntity.getMain(),
        fullWeatherDTO.getMain());
    assertEquals("Converted fullWeather wind should match", fullWeatherEntity.getWind(),
        fullWeatherDTO.getWind());
    assertEquals("Converted fullWeather sys should match", fullWeatherEntity.getSys(),
        fullWeatherDTO.getSys());
    assertEquals("Converted fullWeather rain should match", fullWeatherEntity.getRain(),
        fullWeatherDTO.getRain());
    assertEquals("Converted fullWeather snow should match", fullWeatherEntity.getSnow(),
        fullWeatherDTO.getSnow());
  }
}