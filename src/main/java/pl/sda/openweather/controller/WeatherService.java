package pl.sda.openweather.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class WeatherService {

    private String finalURL;

    public WeatherService(String URL, String APIkey) {
        this.finalURL = URL+APIkey;
    }

    public  void getCityWeather (String City) {
        try {
            URL jsonURL = new URL(finalURL+City);
            ObjectMapper objectMapper = new ObjectMapper();
            Weather weather3 = objectMapper.readValue(jsonURL, Weather.class);
            System.out.println("==============");
            System.out.println("Dla miasta: "+City+" wynosi: "+weather3.getCurrent().getTemp_c()+" st.C");
//            weather3 = objectMapper.readValue(jsonURL, Weather.class);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
