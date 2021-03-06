package com.weather.api.mapper;

import com.weather.api.dto.DateDTO;
import com.weather.core.entity.DateEntity;
import java.util.Date;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface DateMapper {

  @Mapping(source = "dt", target = "date", qualifiedByName = "secToDay")
  DateDTO convertEntityToDto(final DateEntity dateEntity);

  @Named("secToDay")
  default Date convertSecToMillisec(long sec) {

    return new Date(sec * 1000);
  }
}
