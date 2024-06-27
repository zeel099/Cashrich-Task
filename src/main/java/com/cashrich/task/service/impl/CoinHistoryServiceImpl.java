package com.cashrich.task.service.impl;

import com.cashrich.task.entity.CoinHistoryInfo;
import com.cashrich.task.entity.ResponseData;
import com.cashrich.task.repository.CoinHistoryServiceRepository;
import com.cashrich.task.service.CoinHistoryInfoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Slf4j
@Service
public class CoinHistoryServiceImpl implements CoinHistoryInfoService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CoinHistoryServiceRepository coinHistoryServiceRepository;

    private static final String API_URL = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest?symbol=BTC,ETHLTC";
    private static final String API_KEY = "27ab17d1-215f-49e5-9ca4-afd48810c149";

    @Override
    public CoinHistoryInfo fetchCoinData(Long userId) {
        CoinHistoryInfo coinHistoryInfo = new CoinHistoryInfo();
        coinHistoryInfo.setUserId(userId);

        String response = getCryptoQuotes();
        coinHistoryInfo.setResponse(response);

        return coinHistoryServiceRepository.save(coinHistoryInfo);

    }

    public String getCryptoQuotes() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-CMC_PRO_API_KEY", API_KEY);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(API_URL, HttpMethod.GET, entity, String.class);

        log.info("getCryptoQuotes data : {}",response);
        return response.getBody();
    }
    public ResponseData parseResponse(String jsonResponse) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonResponse, ResponseData.class);
    }
}
