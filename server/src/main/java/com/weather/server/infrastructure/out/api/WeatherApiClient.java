package com.weather.server.infrastructure.out.api;

import com.weather.server.infrastructure.out.api.config.PropertiesConfiguration;
import com.weather.server.infrastructure.out.api.response.WeatherApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import static org.springframework.web.util.UriComponentsBuilder.fromUriString;

@Component
public class WeatherApiClient {
    private final RestClient restClient;
    private final PropertiesConfiguration propertiesConfiguration;

    private static final Logger logger = LoggerFactory.getLogger(WeatherApiClient.class);

    public WeatherApiClient(RestClient restClient, PropertiesConfiguration propertiesConfiguration) {
        this.restClient = restClient;
        this.propertiesConfiguration = propertiesConfiguration;
    }

    public WeatherApiResponse fetchWeather(String city) {
        return restClient.get()
                .uri(buildUrl(city))
                .retrieve()
                .onStatus(status -> status.is4xxClientError() || status.is5xxServerError(), (request, response) -> {
                    logger.error("Error fetching weather: {}", response);
                    throw new RuntimeException("API request failed: " + response);
                })
                .body(WeatherApiResponse.class);
    }

    private String buildUrl(String city) {
        return fromUriString(propertiesConfiguration.getUrl())
                .buildAndExpand(city, propertiesConfiguration.getApiKey())
                .toUriString();
    }
}