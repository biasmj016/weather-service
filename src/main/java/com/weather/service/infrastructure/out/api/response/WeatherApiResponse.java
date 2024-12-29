package com.weather.service.infrastructure.out.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record WeatherApiResponse(
        @JsonProperty("weather") List<Weathers> weather,
        @JsonProperty("main") WeatherMetrics main,
        @JsonProperty("wind") Wind wind,
        @JsonProperty("dt") long dt,
        @JsonProperty("sys") WeatherSystemInfo systemInfo,
        @JsonProperty("name") String name
) {

    record Weathers(
            @JsonProperty("main") String main,
            @JsonProperty("description") String description
    ) {}

    record WeatherMetrics(
            @JsonProperty("temp") double temp,
            @JsonProperty("feels_like") double feelsLike,
            @JsonProperty("temp_min") double tempMin,
            @JsonProperty("temp_max") double tempMax,
            @JsonProperty("pressure") int pressure,
            @JsonProperty("humidity") int humidity,
            @JsonProperty("sea_level") int seaLevel,
            @JsonProperty("grnd_level") int groundLevel
    ) {}

    record Wind(
            @JsonProperty("speed") double speed,
            @JsonProperty("deg") int deg
    ) {}

    record WeatherSystemInfo(
            @JsonProperty("country") String country,
            @JsonProperty("sunrise") long sunrise,
            @JsonProperty("sunset") long sunset
    ) {}
}
