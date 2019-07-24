package com.weather.core.service.impl;

import com.weather.api.dto.FullWeatherDTO;
import com.weather.api.mapper.FullWeatherMapper;
import com.weather.core.client.WeatherClient;
import com.weather.core.exeption.ResourceNotFoundException;
import com.weather.core.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiWeatherService implements WeatherService {

  private final WeatherClient weatherClient;
  private final FullWeatherMapper fullWeatherMapper;

  @Autowired
  public ApiWeatherService(WeatherClient weatherClient, FullWeatherMapper fullWeatherMapper) {
    this.weatherClient = weatherClient;
    this.fullWeatherMapper = fullWeatherMapper;
  }

  @Override
  public FullWeatherDTO getFullWeather(long id) {

    return weatherClient
        .get(id)
        .map(fullWeatherMapper::convertEntityToDto)
        .orElseThrow(ResourceNotFoundException::new);
  }
}
