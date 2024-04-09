package com.jmatheus.portfolio.portfolio.services.dto.in.admin.auth;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class LoginDto {
    private String email;
    private String password;
}
