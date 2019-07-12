package com.weather.api.mapper;

import com.weather.api.dto.RainDTO;
import com.weather.api.dto.SnowDTO;
import com.weather.core.entity.RainEntity;
import com.weather.core.entity.SnowEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface SnowMapper {

  SnowDTO convertEntityToDto(final SnowEntity snowEntity);
}