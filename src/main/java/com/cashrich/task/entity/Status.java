package com.cashrich.task.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Status {
    private String timestamp;

    @JsonProperty("error_code")
    private int errorCode;

    @JsonProperty("error_message")
    private String errorMessage;

    private int elapsed;

    @JsonProperty("credit_count")
    private int creditCount;

    private String notice;
}
