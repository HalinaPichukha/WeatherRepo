package com.weather.api.mapper;

import com.weather.api.dto.WeatherDTO;
import com.weather.core.entity.WeatherEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface WeatherMapper {

  WeatherDTO convertEntityToDto(final WeatherEntity weatherEntity);
}