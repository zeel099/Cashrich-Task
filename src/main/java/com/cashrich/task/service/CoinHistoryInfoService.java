package com.cashrich.task.service;

import com.cashrich.task.entity.CoinHistoryInfo;
import com.cashrich.task.entity.ResponseData;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

public interface CoinHistoryInfoService {
    CoinHistoryInfo fetchCoinData(Long userId);
    ResponseData parseResponse(String jsonResponse) throws JsonProcessingException;
}
