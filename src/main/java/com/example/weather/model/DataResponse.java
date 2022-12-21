package com.example.weather.model;

import lombok.Data;

import java.util.HashMap;

@Data
public class DataResponse {
    private String cod;
    private String name;
    private HashMap<String, String> main;

    public DataResponse(String cod, String name, HashMap<String, String> main) {
        this.cod = cod;
        this.name = name;
        this.main = main;
    }

    public DataResponse() {
    }
}
