package com.example.weather.model;

import lombok.Data;

import java.util.HashMap;

@Data
public class DataResponse {
    private String name;
    private HashMap<String, String> main;

    public DataResponse(String name, HashMap<String, String> main) {
        this.name = name;
        this.main = main;
    }

    public DataResponse() {
    }
}
