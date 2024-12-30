package com.weather.server.domain;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import static java.time.format.DateTimeFormatter.ofPattern;

public record Weather(
        String city,
        String date,
        String weather,
        String temperature,
        String temperatureMin,
        String temperatureMax,
        int humidity,
        double windSpeed,
        String sunrise,
        String sunset
) {
    public Weather(String city, long date, String weather, String weatherDetails, double temperature, double temperatureMin, double temperatureMax, int humidity, double windSpeed, long sunrise, long sunset) {
        this(
                city,
                convertTime(date),
                weather + " (" + weatherDetails + ")",
                convertCelsius(temperature),
                convertCelsius(temperatureMin),
                convertCelsius(temperatureMax),
                humidity,
                windSpeed,
                convertTime(sunrise),
                convertTime(sunset)
        );
    }

    private static String convertTime(long timestamp) {
        Instant instant = Instant.ofEpochSecond(timestamp);
        ZonedDateTime dateTime = instant.atZone(ZoneId.of("Asia/Seoul"));
        return dateTime.format(ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    private static String convertCelsius(double kelvin) {
        return "%d°C".formatted((int) (kelvin - 273.15));
    }
}
