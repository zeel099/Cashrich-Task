package com.cashrich.task.controller;

import com.cashrich.task.entity.CoinHistoryInfo;
import com.cashrich.task.entity.ResponseData;
import com.cashrich.task.response.ResponseHandler;
import com.cashrich.task.service.CoinHistoryInfoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class CoinHistoryFetchController {

    @Autowired
    private CoinHistoryInfoService coinHistoryInfoService;
    @GetMapping("/crypto/{userId}/quotes")
    public ResponseEntity<Object> fetchCoinData(@PathVariable Long userId) {
        CoinHistoryInfo coinHistoryInfo = coinHistoryInfoService.fetchCoinData(userId);
        log.info("fetch crypto data: {} for userId: {}", coinHistoryInfo, userId);
        ResponseData responseData;
        try {
            responseData = coinHistoryInfoService.parseResponse(coinHistoryInfo.getResponse());
        } catch (JsonProcessingException e) {
            log.error("Error parsing JSON response", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error parsing JSON response");
        }
        return ResponseEntity.ok(responseData);
    }
}
