package com.weather.server.infrastructure.api;

import com.weather.server.infrastructure.out.api.WeatherApiClient;
import com.weather.server.infrastructure.out.api.config.PropertiesConfiguration;
import com.weather.server.infrastructure.out.api.response.WeatherApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class WeatherApiClientTest {

    @Autowired
    private WeatherApiClient weatherApiClient;

    @Autowired
    private PropertiesConfiguration propertiesConfiguration;

    @Test
    void fetchWeather() {
        String city = "Seoul";
        WeatherApiResponse response = weatherApiClient.fetchWeather(city);

        assertNotNull(response);
        assertNotNull(response.name());
    }
}