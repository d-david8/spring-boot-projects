package ro.ddavid8.springbootprojects.weatherapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.ddavid8.springbootprojects.weatherapi.models.WeatherResponseDTO;
import ro.ddavid8.springbootprojects.weatherapi.services.WeatherService;

import java.io.IOException;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    /**
     * Retrieves the weather information for a specified city.
     *
     * @param city the name of the city for which weather information is to be retrieved
     * @return ResponseEntity containing the weather details for the specified city
     * @throws IOException if an I/O error occurs during the process of retrieving the weather information
     */
    @GetMapping("/api/weatherApi/weather")
    public ResponseEntity<WeatherResponseDTO> getWeather(@RequestParam String city) throws IOException {
        return ResponseEntity.ok(weatherService.getCityWeather(city));
    }
}
