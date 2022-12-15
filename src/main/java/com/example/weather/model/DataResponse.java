package com.example.weather.model;

import lombok.Data;

import java.util.HashMap;

@Data
public class DataResponse {
    private String name;
    private HashMap<String, String> main;
}
