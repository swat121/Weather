package com.example.weather.controller;

import com.example.weather.model.DataResponse;
import com.example.weather.service.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class WeatherController {
    private WeatherService service;

    @GetMapping("/city")
    public String getTemperature(Model model) {
        model.addAttribute("countryName", service.getCountyName());
        model.addAttribute("data", service.getDataResponse().getMain());
        return "main";
    }

    @GetMapping("/")
    public String find(Model model) {
        model.addAttribute("dataResponse", new DataResponse());
        return "find";
    }

    @PostMapping("/")
    public String findProduct(@ModelAttribute("dataResponse") DataResponse dataResponse) {
        service.setCountryName(dataResponse.getName());
        return "redirect:/city";
    }
}
