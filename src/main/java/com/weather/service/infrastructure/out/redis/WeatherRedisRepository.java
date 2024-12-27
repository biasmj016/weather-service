package com.weather.service.infrastructure.out.redis;

import com.weather.service.domain.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Repository
public class WeatherRedisRepository {

    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public WeatherRedisRepository(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Optional<Weather> getCurrentWeather(String city) {
        return Optional.ofNullable((Weather) redisTemplate.opsForValue().get(city));
    }

    public void save(Weather weather) {
        String key = weather.city();
        redisTemplate.opsForValue().set(key, weather, 1800, TimeUnit.SECONDS);//날씨 정보는 30분동안 유효
    }
}
