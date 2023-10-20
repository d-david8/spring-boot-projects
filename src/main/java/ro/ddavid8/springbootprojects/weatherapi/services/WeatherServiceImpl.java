package ro.ddavid8.springbootprojects.weatherapi.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ro.ddavid8.springbootprojects.weatherapi.models.WeatherResponseDTO;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Value("${weather.api}")
    private String apiValue;

    @Value("${weather.apiKey}")
    private String apiKeyValue;

    @Value("${weather.airQuality}")
    private String airQualityValue;

    @Override
    public WeatherResponseDTO getCityWeather(String city) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(apiValue + "key=" + apiKeyValue + "&q=" + city + "&aqi=" + airQualityValue).build();
        Response response = client.newCall(request).execute();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(response.body().string());

        WeatherResponseDTO weatherResponseDTO = new WeatherResponseDTO();

        weatherResponseDTO.setCity(jsonNode.get("location").get("name").textValue());
        weatherResponseDTO.setDescription(jsonNode.get("current").get("condition").get("text").textValue());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime lastUpdated = LocalDateTime.parse(jsonNode.get("current").get("last_updated").textValue(), formatter);
        weatherResponseDTO.setLastUpdated(lastUpdated);
        return weatherResponseDTO;
    }
}
