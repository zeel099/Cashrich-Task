package com.cashrich.task.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Quote {
    private double price;

    @JsonProperty("volume_24h")
    private double volume24h;

    @JsonProperty("volume_change_24h")
    private double volumeChange24h;

    @JsonProperty("percent_change_1h")
    private double percentChange1h;

    @JsonProperty("percent_change_24h")
    private double percentChange24h;

    @JsonProperty("percent_change_7d")
    private double percentChange7d;

    @JsonProperty("percent_change_30d")
    private double percentChange30d;

    @JsonProperty("percent_change_60d")
    private double percentChange60d;

    @JsonProperty("percent_change_90d")
    private double percentChange90d;

    @JsonProperty("market_cap")
    private double marketCap;

    @JsonProperty("market_cap_dominance")
    private double marketCapDominance;

    @JsonProperty("fully_diluted_market_cap")
    private double fullyDilutedMarketCap;

    private Object tvl;

    @JsonProperty("last_updated")
    private String lastUpdated;
}
