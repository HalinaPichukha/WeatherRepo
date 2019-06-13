package com.weather.core.service.impl;

import com.weather.api.dto.WeatherDTO;
import com.weather.api.mapper.WeatherMapper;
import com.weather.core.entity.WeatherEntity;
import com.weather.core.repository.WeatherRepository;
import com.weather.core.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiWeatherService implements WeatherService {

  private final WeatherRepository weatherRepository;
  private final WeatherMapper weatherMapper;

  @Autowired
  public ApiWeatherService(WeatherRepository weatherRepository,
      WeatherMapper weatherMapper) {
    this.weatherRepository = weatherRepository;
    this.weatherMapper = weatherMapper;
  }

  @Override
  public WeatherDTO getWeather() {
    final WeatherEntity weatherEntity = weatherRepository.getWeather();
    return weatherMapper.convertEntityToDto(weatherEntity);
  }
}