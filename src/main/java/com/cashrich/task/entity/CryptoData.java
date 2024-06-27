package com.cashrich.task.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CryptoData {
    private int id;

    private String name;

    private String symbol;

    private String slug;

    @JsonProperty("num_market_pairs")
    private int numMarketPairs;

    @JsonProperty("date_added")
    private String dateAdded;

    private List<String> tags;

    @JsonProperty("max_supply")
    private long maxSupply;

    @JsonProperty("circulating_supply")
    private long circulatingSupply;

    @JsonProperty("total_supply")
    private long totalSupply;

    @JsonProperty("is_active")
    private int isActive;

    @JsonProperty("infinite_supply")
    private boolean infiniteSupply;

    private Object platform;

    @JsonProperty("cmc_rank")
    private int cmcRank;

    @JsonProperty("is_fiat")
    private int isFiat;

    @JsonProperty("self_reported_circulating_supply")
    private Object selfReportedCirculatingSupply;

    @JsonProperty("self_reported_market_cap")
    private Object selfReportedMarketCap;

    @JsonProperty("tvl_ratio")
    private Object tvlRatio;

    @JsonProperty("last_updated")
    private String lastUpdated;

    private USD quote;
}
