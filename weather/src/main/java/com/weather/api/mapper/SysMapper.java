package com.weather.api.mapper;

import com.weather.api.dto.MainDTO;
import com.weather.api.dto.SysDTO;
import com.weather.core.entity.MainEntity;
import com.weather.core.entity.SysEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface SysMapper {

  SysDTO convertEntityToDto(final SysEntity sysEntity);
}