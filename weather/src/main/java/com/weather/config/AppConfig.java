package com.weather.config;

import com.weather.core.entity.WeatherEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  public WeatherEntity weather() {
    return WeatherEntity.builder().build();
  }
}