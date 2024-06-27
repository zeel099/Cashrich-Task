package com.cashrich.task.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
public class ResponseData {
    @JsonProperty("status")
    private Status status;

    @JsonProperty("data")
    private Map<String, CryptoData> data;
}
