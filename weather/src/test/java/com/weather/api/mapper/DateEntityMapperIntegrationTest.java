package com.weather.api.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.weather.api.dto.DateDTO;
import com.weather.core.entity.DateEntity;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DateEntityMapperIntegrationTest {

  @Autowired private DateMapper dateMapper;

  private static final long SECS = 1563961730;

  @Test
  public void testNullWeatherMappedToNullDto() {
    final DateDTO dateDTO = dateMapper.convertEntityToDto(null);

    assertNull("Null date entity should be converted to null dto", dateDTO);
  }

  @Test
  public void testThatWeatherMapperShouldConvertEntityToDto() {

    DateEntity dateEntity = DateEntity.builder().dt(1563961730).build();

    DateDTO dateDTO = dateMapper.convertEntityToDto(dateEntity);

    assertNotNull("Not null date entity can not be null dto", dateDTO);
    assertEquals("Converted date should match", new Date(SECS * 1000), dateDTO.getDate());
  }
}
