package com.weather.api.mapper;

import com.weather.api.dto.MainDTO;
import com.weather.api.dto.RainDTO;
import com.weather.core.entity.MainEntity;
import com.weather.core.entity.RainEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface RainMapper {

  RainDTO convertEntityToDto(final RainEntity rainEntity);
}