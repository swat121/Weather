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

    public void deleteCity(String countryName, String clientIp) {
        cityRepository.deleteCityByCountryNameAndIpAddress(countryName, clientIp);
    }
    public List<City> findAll(){
        return cityRepository.findAll();
    }
    public boolean isCityPresent(String countryName, String ipAddress) {
        List<City> cities = cityRepository.findAllByIpAddress(ipAddress);
        if (cities.isEmpty()) {
            return false;
        }
        if (cities.stream().anyMatch(city -> city.getCountryName().equals(countryName))) {
            return true;
        }
        return false;
    }
}
