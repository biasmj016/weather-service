package com.weather.server.application.in;


import com.weather.server.application.out.WeatherRepository;
import com.weather.server.domain.Weather;
import com.weather.server.infrastructure.out.api.WeatherApiClient;
import com.weather.server.infrastructure.out.api.response.WeatherApiResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class CheckWeatherTest {

    @Mock
    private WeatherRepository weatherRepository;

    @Mock
    private WeatherApiClient weatherApiClient;

    @InjectMocks
    private CheckWeather.CheckWeatherUseCase checkWeatherUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void check_repository() {
        Weather weather = new Weather(
                "Seoul",
                "2023-10-10 10:00:00",
                "Sunny",
                "25°C",
                "20°C",
                "30°C",
                60,
                5.0,
                "06:00:00",
                "18:00:00"
        );
        when(weatherRepository.getCurrentWeather(anyString())).thenReturn(Optional.of(weather));

        Weather result = checkWeatherUseCase.check("Seoul");

        verify(weatherRepository, times(1)).getCurrentWeather("Seoul");
        verify(weatherApiClient, never()).fetchWeather(anyString());
    }

    @Test
    void check_ApiClient() {
        WeatherApiResponse apiResponse = new WeatherApiResponse(
                List.of(new WeatherApiResponse.Weathers("Sunny", "Clear sky")),
                new WeatherApiResponse.WeatherMetrics(298.15, 298.15, 293.15, 303.15, 1013, 60, 1013, 1013),
                new WeatherApiResponse.Wind(5.0, 180),
                1697040000L,
                new WeatherApiResponse.WeatherSystemInfo("KR", 1697000000L, 1697040000L),
                "Seoul"
        );
        Weather weather = apiResponse.toWeather();
        when(weatherRepository.getCurrentWeather(anyString())).thenReturn(Optional.empty());
        when(weatherApiClient.fetchWeather(anyString())).thenReturn(apiResponse);

        Weather result = checkWeatherUseCase.check("Seoul");

        verify(weatherRepository, times(1)).getCurrentWeather("Seoul");
        verify(weatherRepository, times(1)).save(weather);
    }
}