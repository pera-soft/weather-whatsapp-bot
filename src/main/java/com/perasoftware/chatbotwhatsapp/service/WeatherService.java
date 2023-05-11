package com.perasoftware.chatbotwhatsapp.service;

import com.perasoftware.chatbotwhatsapp.model.WeatherForecast;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);
    private final String CURRENT_WEATHER_URL = "http://api.weatherapi.com/v1/current.json?key=%s&q=%f,%f&lang=%s";
    private final WebClient webClient;
    @Value("${weather.auth-token}")
    private String weatherAuthToken;

    public WeatherForecast getWeatherForecast(float latitude, float longitude, String lang){
        String requestUrl = String.format(
                CURRENT_WEATHER_URL,
                weatherAuthToken,
                latitude,
                longitude,
                lang
        );
        WeatherForecast weatherForecast = webClient
                .get()
                .uri(requestUrl)
                .retrieve()
                .bodyToMono(WeatherForecast.class)
                .block();
        logger.info("Weather Forecast: {}", weatherForecast);
        return weatherForecast;
    }
}
