package com.weather.api.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.weather.api.dto.MainDTO;
import com.weather.core.entity.MainEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainEntityMapperIntegrationTest {

  @Autowired
  private MainMapper mainMapper;

  @Test
  public void testNullMainMappedToNullDto() {
    final MainDTO mainDTO = mainMapper.convertEntityToDto(null);

    assertNull("Null main entity should be converted to null dto", mainDTO);
  }

  @Test
  public void testThatMainMapperShouldConvertEntityToDto() {

    MainEntity mainEntity = MainEntity.builder()
        .temp(0.0)
        .temp_max(0.1)
        .temp_min(0.2)
        .build();

    MainDTO mainDTO = mainMapper.convertEntityToDto(mainEntity);

    assertNotNull("Not null main can not be null", mainDTO);
    assertEquals("Converted main temp should match", 0,
        Math.abs(mainEntity.getTemp() - mainDTO.getTemp()), 0.0);
    assertEquals("Converted main temp_max should match", 0,
        Math.abs(mainEntity.getTemp_max() - mainDTO.getTemp_max()), 0.0);
    assertEquals("Converted main temp_min should match", 0,
        Math.abs(mainEntity.getTemp_min() - mainDTO.getTemp_min()), 0.0);
  }
}