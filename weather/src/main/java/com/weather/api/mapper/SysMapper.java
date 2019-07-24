package com.weather.api.mapper;

import com.weather.api.dto.CountryInfoDTO;
import com.weather.core.entity.SysEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface SysMapper {

  CountryInfoDTO convertEntityToDto(final SysEntity sysEntity);
}
