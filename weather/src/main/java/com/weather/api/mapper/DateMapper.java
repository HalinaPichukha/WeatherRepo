package com.weather.api.mapper;

import com.weather.api.dto.DateDTO;
import com.weather.core.entity.DateEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface DateMapper {

  @Mapping(source = "dt", target = "date")
  DateDTO convertEntityToDto(final DateEntity dateEntity);
}
