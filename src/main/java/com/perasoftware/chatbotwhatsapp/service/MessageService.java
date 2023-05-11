package com.perasoftware.chatbotwhatsapp.service;

import com.perasoftware.chatbotwhatsapp.model.LocationMessage;
import com.perasoftware.chatbotwhatsapp.model.WeatherForecast;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MessageService {
    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);
    private final String WEATHER_FORECAST_MESSAGE = "%s için Hava Durumu: %s,\nSıcaklık: %.2f Derece,\nHissedilen Sıcaklık: %.2f Derece.";
    private final WeatherService weatherService;

    @Value("${twilio.account-sid}")
    private String twilioApiKey;
    @Value("${twilio.auth-token}")
    private String twilioAuthToken;

    public void sendWeatherForecastMessage(LocationMessage locationMessage){
        Twilio.init(twilioApiKey, twilioAuthToken);

        float latitude = Float.parseFloat(locationMessage.getLatitude());
        float longitude = Float.parseFloat(locationMessage.getLongitude());
        WeatherForecast weatherForecast = weatherService.getWeatherForecast(latitude, longitude, "tr");

        String weatherForecastMessage = getWeatherForecastMessage(weatherForecast);

        PhoneNumber to = new PhoneNumber(locationMessage.getFrom());
        PhoneNumber from = new PhoneNumber(locationMessage.getTo());

        Message sentMessage = Message.creator(
                to,
                from,
                weatherForecastMessage
        ).create();
        logger.info("Sent message with SID: {}", sentMessage.getSid());
    }

    public String getWeatherForecastMessage(WeatherForecast weatherForecast){
        return String.format(WEATHER_FORECAST_MESSAGE,
                weatherForecast.getLocation().getRegion(),
                weatherForecast.getCurrent().getCondition().getText(),
                weatherForecast.getCurrent().getTemp_c(),
                weatherForecast.getCurrent().getFeelslike_c()
        );
    }
}
