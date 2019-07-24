package com.weather.api.controller;

import com.weather.api.dto.FullWeatherDTO;
import com.weather.core.service.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
@Api("/api/weather")
public class WeatherRestController {

  private final WeatherService weatherService;

  @Autowired
  public WeatherRestController(WeatherService weatherService) {
    this.weatherService = weatherService;
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(
      value = "The weather in your city",
      notes = "Return a current weather for your city",
      response = String.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Seccessful"),
        @ApiResponse(code = 401, message = "Unautothorized"),
        @ApiResponse(code = 500, message = "Internal server error")
      })
  public FullWeatherDTO getWeather(
      @ApiParam(value = "type city ID to get info", required = true, example = "625144")
          @PathVariable("id")
          long id) {
    return weatherService.getFullWeather(id);
  }
}
