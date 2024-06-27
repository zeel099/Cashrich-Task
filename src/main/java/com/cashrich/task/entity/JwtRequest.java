package com.cashrich.task.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JwtRequest {

    private String userName;

    private String password;
}
