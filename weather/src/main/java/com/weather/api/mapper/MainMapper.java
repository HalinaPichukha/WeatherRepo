package com.weather.api.mapper;

import com.weather.api.dto.MainDTO;
import com.weather.core.entity.MainEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface MainMapper {

  MainDTO convertEntityToDto(final MainEntity mainEntity);
}