package com.example.weather.service;

import com.example.weather.model.City;
import com.example.weather.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DataService {
    private final CityRepository cityRepository;

    public void saveCity(City city) {
        cityRepository.save(city);
    }

    public List<City> findAllByIpAddress(String ipAddress) {
        return cityRepository.findAllByIpAddress(ipAddress);
    }
}
