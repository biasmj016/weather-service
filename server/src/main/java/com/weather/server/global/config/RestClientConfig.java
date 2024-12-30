package com.weather.server.global.config;

import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestClient;

import java.nio.charset.StandardCharsets;

@Configuration
public class RestClientConfig {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Bean
    public RestClient restClient() {
        return RestClient.builder()
                .requestFactory(new BufferingClientHttpRequestFactory(httpFactory()))
                .requestInterceptor(loggingInterceptor())
                .build();
    }


    @NotNull
    private static SimpleClientHttpRequestFactory httpFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(10000);
        factory.setConnectTimeout(10000);
        return factory;
    }


    private ClientHttpRequestInterceptor loggingInterceptor() {
        return (request, body, execution) -> {
            logger.info("[HTTP REQUEST] URI: {} {}", request.getMethod(), request.getURI());
            var response = execution.execute(request, body);
            logger.info("[HTTP RESPONSE] STATUS: {} BODY: {}", response.getStatusCode(), StreamUtils.copyToString(response.getBody(), StandardCharsets.UTF_8));
            return response;
        };
    }
}
