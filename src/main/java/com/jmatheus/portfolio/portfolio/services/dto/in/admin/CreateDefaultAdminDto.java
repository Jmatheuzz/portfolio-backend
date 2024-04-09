package com.jmatheus.portfolio.portfolio.services.dto.in.admin;

import com.jmatheus.portfolio.portfolio.models.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class CreateDefaultAdminDto {
    private String name;
    private String email;
    private String password;
    private boolean isVerified;
    private Role role;
}
