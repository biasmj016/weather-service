package com.weather.service.application.in;

import com.weather.service.application.out.WeatherRepository;
import com.weather.service.domain.Weather;
import com.weather.service.infrastructure.out.api.WeatherApiClient;
import org.springframework.stereotype.Service;

public interface CheckWeather {
    Weather check(String city);

    @Service
    class CheckWeatherUseCase implements CheckWeather {
        private final WeatherRepository repository;
        private final WeatherApiClient weatherApiClient;

        public CheckWeatherUseCase(WeatherRepository repository, WeatherApiClient weatherApiClient) {
            this.repository = repository;
            this.weatherApiClient = weatherApiClient;
        }

        @Override
        public Weather check(String city) {
            return repository.getCurrentWeather(city)
                    .orElseGet(() -> {
                        Weather fetchedWeather = weatherApiClient.fetchWeather(city).toWeather();
                        repository.save(fetchedWeather);
                        return fetchedWeather;
                    });
        }
    }
}