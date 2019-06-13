package com.weather.api.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.weather.WeatherApplication;
import com.weather.api.dto.WeatherDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WeatherApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class WeatherRestControllerIntegrationTest {

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void getWeatherShouldReturnWeatherWithOk() {
    ResponseEntity<WeatherDTO> response = restTemplate.exchange(
        "/api/weather",
        HttpMethod.GET,
        HttpEntity.EMPTY,
        WeatherDTO.class
    );

    assertNotNull("Response shouldn't be null", response.getBody());
    assertEquals("Status should be OK", HttpStatus.OK, response.getStatusCode());
  }
}