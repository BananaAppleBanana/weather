package com.example.search.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface WeatherService {
    List<Integer> findCityIdByName(String city);
    Map<String, Map> findCityNameById(int id);
}
