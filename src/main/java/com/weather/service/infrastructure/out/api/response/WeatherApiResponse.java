package com.weather.service.infrastructure.out.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record WeatherApiResponse(
        @JsonProperty("coord") Coordinates coordinates,
        @JsonProperty("weather") List<Weather> weather,
        @JsonProperty("base") String base,
        @JsonProperty("main") WeatherMetrics main,
        @JsonProperty("visibility") int visibility,
        @JsonProperty("wind") Wind wind,
        @JsonProperty("clouds") Clouds clouds,
        @JsonProperty("dt") int dt,
        @JsonProperty("sys") WeatherSystemInfo systemInfo,
        @JsonProperty("timezone") int timezone,
        @JsonProperty("id") int id,
        @JsonProperty("name") String name,
        @JsonProperty("cod") int cod
) {

    record Coordinates(
            @JsonProperty("lon") double longitude,
            @JsonProperty("lat") double latitude
    ) {}

    record Weather(
            @JsonProperty("id") int id,
            @JsonProperty("main") String main,
            @JsonProperty("description") String description,
            @JsonProperty("icon") String icon
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

    record Clouds(
            @JsonProperty("all") int all
    ) {}

    record WeatherSystemInfo(
            @JsonProperty("type") int type,
            @JsonProperty("id") int id,
            @JsonProperty("country") String country,
            @JsonProperty("sunrise") long sunrise,
            @JsonProperty("sunset") long sunset
    ) {}
}
