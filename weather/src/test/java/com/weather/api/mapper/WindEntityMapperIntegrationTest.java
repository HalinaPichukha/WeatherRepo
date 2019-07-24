package com.weather.api.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.weather.api.dto.WindDTO;
import com.weather.core.entity.WindEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WindEntityMapperIntegrationTest {

  @Autowired
  private WindMapper windMapper;

  @Test
  public void testNullWindMappedToNullDto() {
    final WindDTO windDTO = windMapper.convertEntityToDto(null);

    assertNull("Null wind entity should be converted to null dto", windDTO);
  }

  @Test
  public void testThatWindMapperShouldConvertEntityToDto() {

    WindEntity windEntity = WindEntity.builder().speed(0.1).build();

    WindDTO windDTO = windMapper.convertEntityToDto(windEntity);

    assertNotNull("Not null wind can not be null", windDTO);
    assertEquals("Converted wind speed should match", 0,
        Math.abs(windEntity.getSpeed() - windDTO.getSpeed()), 0.0);
  }
}