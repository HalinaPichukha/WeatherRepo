package com.weather.core.client;

import com.weather.core.entity.FullWeatherEntity;
import java.util.Optional;

public interface WeatherClient {

  Optional<FullWeatherEntity> get(long id);
}