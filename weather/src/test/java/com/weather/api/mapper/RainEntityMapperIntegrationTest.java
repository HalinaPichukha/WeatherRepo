package com.weather.api.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.weather.api.dto.RainDTO;
import com.weather.core.entity.RainEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RainEntityMapperIntegrationTest {

  @Autowired
  private RainMapper rainMapper;

  @Test
  public void testNullRainMappedToNullDto() {
    final RainDTO rainDTO = rainMapper.convertEntityToDto(null);

    assertNull("Null rain entity should be converted to null dto list", rainDTO);
  }

  @Test
  public void testThatRainMapperShouldConvertEntityToDto() {

    RainEntity rainEntity = RainEntity.builder()
        .oneHoursRain(0.0)
        .threeHoursRain(0.1)
        .build();

    RainDTO rainDTO = rainMapper.convertEntityToDto(rainEntity);

    assertNotNull("Not null main can not be null", rainDTO);
    assertEquals("Converted rain oneHoursRain should match", 0,
        Math.abs(rainEntity.getOneHoursRain() - rainDTO.getOneHoursRain()), 0.0);
    assertEquals("Converted rain threeHoursRain should match", 0,
        Math.abs(rainEntity.getThreeHoursRain() - rainDTO.getThreeHoursRain()), 0.0);
  }
}