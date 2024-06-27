package com.cashrich.task.entity;


import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="CoinHistoryInfo")
public class CoinHistoryInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    @Column(columnDefinition = "TEXT")
    private String response;
}
