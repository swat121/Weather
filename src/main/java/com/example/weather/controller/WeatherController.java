package com.example.weather.controller;

import com.example.weather.service.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WeatherController {
    private WeatherService service;

    @GetMapping("/")
    public String getTemperature(Model model){
        model.addAttribute("countryName", service.getCountyName());
        model.addAttribute("data", service.getDataResponse().getMain());
        return "main";
    }
}
