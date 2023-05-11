package com.perasoftware.chatbotwhatsapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Condition{
    private String text;
    private String icon;
    private int code;
}
