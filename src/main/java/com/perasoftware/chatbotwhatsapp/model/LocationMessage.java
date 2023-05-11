package com.perasoftware.chatbotwhatsapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LocationMessage{
    @JsonProperty("Latitude")
    private String latitude;
    @JsonProperty("Longitude")
    private String longitude;
    @JsonProperty("Address")
    private String address;
    @JsonProperty("SmsMessageSid")
    private String smsMessageSid;
    @JsonProperty("NumMedia")
    private String numMedia;
    @JsonProperty("ProfileName")
    private String profileName;
    @JsonProperty("SmsSid")
    private String smsSid;
    @JsonProperty("WaId")
    private String waId;
    @JsonProperty("SmsStatus")
    private String smsStatus;
    @JsonProperty("Label")
    private String label;
    @JsonProperty("Body")
    private String body;
    @JsonProperty("To")
    private String to;
    @JsonProperty("NumSegments")
    private String numSegments;
    @JsonProperty("ReferralNumMedia")
    private String referralNumMedia;
    @JsonProperty("MessageSid")
    private String messageSid;
    @JsonProperty("AccountSid")
    private String accountSid;
    @JsonProperty("From")
    private String from;
    @JsonProperty("ApiVersion")
    private String apiVersion;
}
