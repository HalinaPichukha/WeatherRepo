package com.weather.api.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.weather.api.dto.WeatherDTO;
import com.weather.core.entity.WeatherEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherEntityMapperIntegrationTest {

  @Autowired
  private WeatherMapper weatherMapper;

  @Test
  public void testNullWeatherMappedToNullDto() {
    final WeatherDTO weatherDTO = weatherMapper.convertEntityToDto(null);

    assertNull("Null weather entity should be converted to null dto", weatherDTO);
  }

  @Test
  public void testThatWeatherMapperShouldConvertEntityToDto() {

    WeatherEntity weatherEntity = WeatherEntity.builder()
        .main("main")
        .description("description")
        .build();

    WeatherDTO weatherDTO = weatherMapper.convertEntityToDto(weatherEntity);

    assertNotNull("Not null sys can not be null", weatherDTO);
    assertEquals("Converted weather main should match", weatherEntity.getMain(),
        weatherDTO.getMain());
    assertEquals("Converted weather description should match", weatherEntity.getDescription(),
        weatherDTO.getDescription());
  }
}