package com.weather.core.service;

import com.weather.api.dto.FullWeatherDTO;

public interface WeatherService {

  FullWeatherDTO getFullWeather(long id);
}
