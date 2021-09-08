package com.example.search.controller;

import com.example.search.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    @Value("${server.port}")
    private int randomServerPort;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public ResponseEntity<?> queryWeatherByCity(@RequestParam(required = true) String city) {
        return new ResponseEntity<>(weatherService.findCityIdByName(city), HttpStatus.OK);
    }


    @GetMapping("/weather/{id}")
    public ResponseEntity<?> queryWeatherByCity(@PathVariable int id) {
        return new ResponseEntity<Map>(weatherService.findCityNameById(id), HttpStatus.OK);
    }

    @GetMapping("/weather/port")
    public ResponseEntity<?> queryWeatherByCity() {
        return new ResponseEntity<>("weather service + " + randomServerPort, HttpStatus.OK);
    }
}
