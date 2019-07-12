package com.weather.api.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.weather.api.dto.SnowDTO;
import com.weather.core.entity.SnowEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SnowEntityMapperIntegrationTest {

  @Autowired
  private SnowMapper snowMapper;

  @Test
  public void testNullSnowMappedToNullDto() {
    final SnowDTO snowDTO = snowMapper.convertEntityToDto(null);

    assertNull("Null snow entity should be converted to null dto", snowDTO);
  }

  @Test
  public void testThatSnowMapperShouldConvertEntityToDto() {

    SnowEntity snowEntity = SnowEntity.builder()
        .oneHoursSnow(0.0)
        .threeHoursSnow(0.1)
        .build();

    SnowDTO snowDTO = snowMapper.convertEntityToDto(snowEntity);

    assertNotNull("Not null main can not be null", snowDTO);
    assertEquals("Converted snow oneHoursSnow should match", 0,
        Math.abs(snowEntity.getOneHoursSnow() - snowDTO.getOneHoursSnow()), 0.0);
    assertEquals("Converted snow threeHoursSnow should match", 0,
        Math.abs(snowEntity.getThreeHoursSnow() - snowDTO.getThreeHoursSnow()), 0.0);
  }
}