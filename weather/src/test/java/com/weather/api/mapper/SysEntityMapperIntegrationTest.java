package com.weather.api.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.weather.api.dto.CountryInfoDTO;
import com.weather.core.entity.SysEntity;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysEntityMapperIntegrationTest {

  @Autowired private CountryInfoMapper countryInfoMapper;

  private static final long SECS = 1563961730;
  private final Date date = new Date(SECS * 1000);

  @Test
  public void testNullSysMappedToNullDto() {
    final CountryInfoDTO countryInfoDTO = countryInfoMapper.convertEntityToDto(null);

    assertNull("Null sys entity should be converted to null dto", countryInfoDTO);
  }

  @Test
  public void testThatSysMapperShouldConvertEntityToDto() {

    SysEntity sysEntity = SysEntity.builder().country("Country").sunrise(1563961730).sunset(1563961730).build();

    CountryInfoDTO countryInfoDTO = countryInfoMapper.convertEntityToDto(sysEntity);

    assertNotNull("Not null sys can not be null", countryInfoDTO);
    assertEquals(
        "Converted sys country should match", "Country", countryInfoDTO.getCountry());
    assertEquals(
        "Converted sys sunrise should match", date, countryInfoDTO.getSunrise());
    assertEquals(
        "Converted sys sunset should match", date, countryInfoDTO.getSunset());
  }
}
