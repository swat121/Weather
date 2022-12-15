package com.example.weather.service;

import com.example.weather.config.UrlConfig;
import com.example.weather.model.DataResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private final RestTemplate restTemplate;
    private final String url = "https://api.openweathermap.org/data/2.5/";
    private final UrlConfig urlConfig;

    public DataResponse getDataResponse() {
        System.out.println("===========    "+ urlConfig.getCountryName());
        URI uri = URI.create(url).resolve(String.format("weather?q=%s&units=%s&appid=%s", urlConfig.getCountryName(), urlConfig.getUnits(), urlConfig.getId()));
        System.out.println(uri.toString()+ " ------------------------------------");
        return getFromUrl(uri.toString(), DataResponse.class);
    }

    public String getCountyName(){
        return urlConfig.getCountryName();
    }

    private <T> T getFromUrl(String url, Class<T> responseType) {
        return restTemplate.getForEntity(url, responseType).getBody();
    }
}
