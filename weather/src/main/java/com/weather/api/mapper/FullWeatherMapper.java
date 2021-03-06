package com.weather.api.mapper;

import com.weather.api.dto.FullWeatherDTO;
import com.weather.core.entity.FullWeatherEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    componentModel = "spring",
    uses = {
      TemperatureMapper.class,
      RainMapper.class,
      SnowMapper.class,
      CountryInfoMapper.class,
      WeatherMapper.class,
      WindMapper.class,
      DateMapper.class
    })
public interface FullWeatherMapper {

  @Mapping(source = "main", target = "temperature")
  @Mapping(source = "sys", target = "countryInfo")
  @Mapping(source = "dt", target = "date")
  FullWeatherDTO convertEntityToDto(final FullWeatherEntity fullWeatherEntity);
}
