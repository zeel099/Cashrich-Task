package com.cashrich.task.repository;

import com.cashrich.task.entity.CoinHistoryInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoinHistoryServiceRepository extends JpaRepository<CoinHistoryInfo,Long> {
    Optional<CoinHistoryInfo>findById(Long userId);
}
