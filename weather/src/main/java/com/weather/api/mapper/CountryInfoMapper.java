package com.weather.api.mapper;

import com.weather.api.dto.CountryInfoDTO;
import com.weather.core.entity.SysEntity;
import java.util.Date;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface CountryInfoMapper {

  @Mapping(source = "sunrise", target = "sunrise", qualifiedByName = "secToDay")
  @Mapping(source = "sunset", target = "sunset", qualifiedByName = "secToDay")
  CountryInfoDTO convertEntityToDto(final SysEntity sysEntity);

  @Named("secToDay")
  default Date convertSecToMillisec(long sec) {

    return new Date(sec * 1000);
  }
}
