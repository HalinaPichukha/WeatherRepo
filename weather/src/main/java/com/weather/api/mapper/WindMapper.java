package com.weather.api.mapper;

import com.weather.api.dto.MainDTO;
import com.weather.api.dto.WindDTO;
import com.weather.core.entity.MainEntity;
import com.weather.core.entity.WindEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface WindMapper {

  WindDTO convertEntityToDto(final WindEntity windEntity);
}