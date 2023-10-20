package ro.ddavid8.springbootprojects.weatherapi.services;

import ro.ddavid8.springbootprojects.weatherapi.models.WeatherResponseDTO;

import java.io.IOException;

public interface WeatherService {

    WeatherResponseDTO getCityWeather(String city) throws IOException;
}
