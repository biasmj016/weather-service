package com.weather.service.application.out;

import com.weather.service.domain.Weather;
import com.weather.service.infrastructure.out.redis.WeatherRedisRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface WeatherRepository {
    Optional<Weather> getCurrentWeather(String city);
    void save(Weather weather);

    @Repository
    class WeatherRepositoryImpl implements WeatherRepository {
        private final WeatherRedisRepository weatherRedisRepository;

        public WeatherRepositoryImpl(WeatherRedisRepository weatherRedisRepository) {
            this.weatherRedisRepository = weatherRedisRepository;
        }

        @Override
        public Optional<Weather> getCurrentWeather(String city) {
            return weatherRedisRepository.getCurrentWeather(city);
        }

        @Override
        public void save(Weather weather) {
            weatherRedisRepository.save(weather);
        }
    }
}