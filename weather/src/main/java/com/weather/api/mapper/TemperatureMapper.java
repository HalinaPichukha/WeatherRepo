package com.weather.api.mapper;

import com.weather.api.dto.TemperatureDTO;
import com.weather.core.entity.MainEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface TemperatureMapper {

  TemperatureDTO convertEntityToDto(final MainEntity mainEntity);
}