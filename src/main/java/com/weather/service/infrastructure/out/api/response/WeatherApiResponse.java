package com.weather.service.infrastructure.out.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.weather.service.domain.Weather;

import java.util.List;

public record WeatherApiResponse(
        @JsonProperty("weather") List<Weathers> weather,
        @JsonProperty("main") WeatherMetrics main,
        @JsonProperty("wind") Wind wind,
        @JsonProperty("dt") long dt,
        @JsonProperty("sys") WeatherSystemInfo systemInfo,
        @JsonProperty("name") String name
) {

    public record Weathers(
            @JsonProperty("main") String main,
            @JsonProperty("description") String description
    ) {}

    public record WeatherMetrics(
            @JsonProperty("temp") double temp,
            @JsonProperty("feels_like") double feelsLike,
            @JsonProperty("temp_min") double tempMin,
            @JsonProperty("temp_max") double tempMax,
            @JsonProperty("pressure") int pressure,
            @JsonProperty("humidity") int humidity,
            @JsonProperty("sea_level") int seaLevel,
            @JsonProperty("grnd_level") int groundLevel
    ) {}

    public record Wind(
            @JsonProperty("speed") double speed,
            @JsonProperty("deg") int deg
    ) {}

    public record WeatherSystemInfo(
            @JsonProperty("country") String country,
            @JsonProperty("sunrise") long sunrise,
            @JsonProperty("sunset") long sunset
    ) {}

   public Weather toWeather() {
        Weathers weathers = this.weather.getFirst();
        return new Weather(
                name,
                dt,
                weathers.main(),
                weathers.description(),
                main.temp(),
                main.tempMin(),
                main.tempMax(),
                main.humidity(),
                wind.speed(),
                systemInfo.sunrise(),
                systemInfo.sunset()
        );
    }
}
