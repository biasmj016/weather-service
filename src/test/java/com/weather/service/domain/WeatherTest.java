package com.weather.service.domain;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

class WeatherTest {

    @Test
    void constructor() {
        Weather weather = new Weather(
                "Seoul",
                1735473115,
                "Clouds",
                "Scattered Clouds",
                273.91,
                272.93,
                273.91,
                64,
                1,
                1735425975,
                1735460501
        );

        System.out.println(weather);
    }

    @Test
    void convertToTime() {
        System.out.println(convertToTime(1735473115));
        System.out.println(273.91- 273.15);
    }

    private String convertToTime(long time) {
        Instant instant = Instant.ofEpochSecond(time);
        ZonedDateTime dateTime = instant.atZone(ZoneId.of("Asia/Seoul"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTime.format(formatter);
    }
}