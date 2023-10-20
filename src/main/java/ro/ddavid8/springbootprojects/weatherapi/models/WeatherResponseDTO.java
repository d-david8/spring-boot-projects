package ro.ddavid8.springbootprojects.weatherapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponseDTO {
    private String city;
    private String description;
    private LocalDateTime lastUpdated;
}
