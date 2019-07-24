package com.weather.api.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.weather.api.dto.TemperatureDTO;
import com.weather.core.entity.MainEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainEntityMapperIntegrationTest {

  @Autowired private TemperatureMapper temperatureMapper;

  @Test
  public void testNullMainMappedToNullDto() {
    final TemperatureDTO temperatureDTO = temperatureMapper.convertEntityToDto(null);

    assertNull("Null main entity should be converted to null dto", temperatureDTO);
  }

  @Test
  public void testThatMainMapperShouldConvertEntityToDto() {

    MainEntity mainEntity = MainEntity.builder().temp(0.0).temp_max(0.1).temp_min(0.2).build();

    TemperatureDTO temperatureDTO = temperatureMapper.convertEntityToDto(mainEntity);

    assertNotNull("Not null main can not be null", temperatureDTO);
    assertEquals(
        "Converted main temp should match",
        0,
        Math.abs(mainEntity.getTemp() - temperatureDTO.getTemp()),
        0.0);
    assertEquals(
        "Converted main temp_max should match",
        0,
        Math.abs(mainEntity.getTemp_max() - temperatureDTO.getTemp_max()),
        0.0);
    assertEquals(
        "Converted main temp_min should match",
        0,
        Math.abs(mainEntity.getTemp_min() - temperatureDTO.getTemp_min()),
        0.0);
  }
}
