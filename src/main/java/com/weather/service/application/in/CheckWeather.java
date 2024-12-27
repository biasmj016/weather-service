package com.weather.service.application.in;

import com.weather.service.application.in.request.CheckWeatherRequest;
import com.weather.service.application.out.WeatherRepository;
import com.weather.service.domain.Weather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

public interface CheckWeather {
    Weather check(CheckWeatherRequest request);

    @Service
    class CheckWeatherUseCase implements CheckWeather {
        private final WeatherRepository repository;
        private final Logger logger = LoggerFactory.getLogger(this.getClass());

        public CheckWeatherUseCase(WeatherRepository repository) {
            this.repository = repository;
        }

        @Override
        public Weather check(CheckWeatherRequest request) {
            return repository.getCurrentWeather(request.city()).get();
        }
    }
}
