package com.weather.api.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.weather.api.dto.CountryInfoDTO;
import com.weather.core.entity.SysEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysEntityMapperIntegrationTest {

  @Autowired private SysMapper sysMapper;

  @Test
  public void testNullSysMappedToNullDto() {
    final CountryInfoDTO countryInfoDTO = sysMapper.convertEntityToDto(null);

    assertNull("Null sys entity should be converted to null dto", countryInfoDTO);
  }

  @Test
  public void testThatSysMapperShouldConvertEntityToDto() {

    SysEntity sysEntity = SysEntity.builder().country("Country").sunrise(1L).sunset(2L).build();

    CountryInfoDTO countryInfoDTO = sysMapper.convertEntityToDto(sysEntity);

    assertNotNull("Not null sys can not be null", countryInfoDTO);
    assertEquals(
        "Converted sys country should match", sysEntity.getCountry(), countryInfoDTO.getCountry());
    assertEquals(
        "Converted sys sunrise should match", sysEntity.getSunrise(), countryInfoDTO.getSunrise());
    assertEquals(
        "Converted sys sunset should match", sysEntity.getSunset(), countryInfoDTO.getSunset());
  }
}
