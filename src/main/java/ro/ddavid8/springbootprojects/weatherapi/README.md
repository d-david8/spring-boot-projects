# Weather API

This API utilizes an external weather API at http://api.weatherapi.com/v1/current.json to retrieve weather data and
provides a simplified response.

- Endpoint: `/api/weatherApi/weather?city={city}`
- Method: `GET`
- Response:
  ```json
  {
    "city": "Cluj-Napoca",
    "description": "Clear",
    "lastUpdated": "2023-10-20T09:45:00"
  }
  ```