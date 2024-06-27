package com.cashrich.task.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class USD {
    @JsonProperty("USD")
    private Quote USD;
}
