package com.weather.api.mapper;

import com.weather.api.dto.FullWeatherDTO;
import com.weather.core.entity.FullWeatherEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring",
uses = {MainMapper.class, RainMapper.class, SnowMapper.class, SysMapper.class, WeatherMapper.class, WindMapper.class})
public interface FullWeatherMapper {

  FullWeatherDTO convertEntityToDto(final FullWeatherEntity fullWeatherEntity);
}