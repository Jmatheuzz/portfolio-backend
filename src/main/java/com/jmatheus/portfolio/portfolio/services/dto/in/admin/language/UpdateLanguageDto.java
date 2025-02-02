package com.jmatheus.portfolio.portfolio.services.dto.in.admin.language;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class UpdateLanguageDto {
    private Long id;
    private String name;
}
