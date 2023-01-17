package com.example.weather.controller;

import com.example.weather.model.City;
import com.example.weather.model.DataResponse;
import com.example.weather.service.DataService;
import com.example.weather.service.WeatherService;
import com.example.weather.util.WebUtil;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class RequestController {
    private final WeatherService weatherService;
    private final DataService dataService;
    private final WebUtil webUtil;

    @RequestMapping(EndPoints.API_CITY)
    public DataResponse getCityByName(@RequestParam(value = "name", required = false, defaultValue = "Dnipro") String countryName) {
        return new DataResponse(weatherService.getDataResponse(countryName).getCod(), countryName, weatherService.getDataResponse(countryName).getMain());
    }

    @RequestMapping(EndPoints.API_USER)
    public List<City> getDataOfUser() {
        return dataService.findAllByIpAddress(webUtil.getClientIp());
    }

    @RequestMapping(EndPoints.API_USER_CITY)
    public List<City> getCityOfUser() {
        return dataService.findAllByIpAddress(webUtil.getClientIp());
    }

    @RequestMapping(EndPoints.API_USERS)
    public List<City> getDataOfUsers() {
        return dataService.findAll().stream().sorted(Comparator.comparing(City::getIpAddress)).collect(Collectors.toList());
    }
}
