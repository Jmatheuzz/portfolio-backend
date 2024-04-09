package com.jmatheus.portfolio.portfolio.services.dto.out.admin.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoggedDto {
    private String token;
}
