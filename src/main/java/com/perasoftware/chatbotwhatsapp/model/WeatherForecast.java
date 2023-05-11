package com.perasoftware.chatbotwhatsapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WeatherForecast {
    private Location location;
    private Current current;
}
