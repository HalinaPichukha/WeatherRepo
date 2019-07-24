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
      SysMapper.class,
      WeatherMapper.class,
      WindMapper.class
    })
public interface FullWeatherMapper {

  @Mapping(source = "main", target = "temperature")
  @Mapping(source = "sys", target = "countryInfo")
  FullWeatherDTO convertEntityToDto(final FullWeatherEntity fullWeatherEntity);
}
