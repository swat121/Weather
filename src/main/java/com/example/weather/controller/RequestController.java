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

import java.util.List;

@RestController
@AllArgsConstructor
public class RequestController {
    private final WeatherService weatherService;
    private final DataService dataService;
    private final WebUtil webUtil;

    @RequestMapping("/city/json")
    public DataResponse getCityByName(@RequestParam(value = "countryName", required = false, defaultValue = "Dnipro") String countryName) {
        return new DataResponse(weatherService.getDataResponse(countryName).getCod(), countryName, weatherService.getDataResponse(countryName).getMain());
    }

    @RequestMapping("/user")
    public List<City> getData() {
        return dataService.findAllByIpAddress(webUtil.getClientIp());
    }

    @RequestMapping("/user/all")
    public List<City> getAllData() {
        return dataService.findAll();
    }
}
