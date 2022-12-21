package com.example.weather.controller;

import com.example.weather.model.City;
import com.example.weather.model.DataResponse;
import com.example.weather.service.DataService;
import com.example.weather.service.WeatherService;
import com.example.weather.util.WebUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@Controller
@AllArgsConstructor
public class WeatherController {
    private final WeatherService service;
    private final DataService dataService;
    private final WebUtil webUtil;

    @GetMapping("/city")
    public String getTemperature(Model model) {
        List<City> cities = dataService.findAllByIpAddress(webUtil.getClientIp());
        HashMap<String, HashMap<String, String>> main = new HashMap<>();
        for (City city : cities) {
            main.put(city.getCountryName(), service.getDataResponse(city.getCountryName()).getMain());
        }
        model.addAttribute("data", main);
        return "main";
    }

    @GetMapping("/")
    public String find(Model model) {
        model.addAttribute("dataResponse", new DataResponse());
        return "find";
    }

    @PostMapping("/")
    public String findProduct(@ModelAttribute("dataResponse") DataResponse dataResponse) {
        City city = new City();
        city.setCountryName(dataResponse.getName());
        city.setIpAddress(webUtil.getClientIp());
        dataService.saveCity(city);
        return "redirect:/city";
    }

    @GetMapping("/city/delete")
    public String deleteCity(@RequestParam String countryName){
        dataService.deleteCity(countryName, webUtil.getClientIp());
        return "redirect:/city";
    }
}
