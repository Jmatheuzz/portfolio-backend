package com.jmatheus.portfolio.portfolio.services.dto.out.admin.language;

import com.jmatheus.portfolio.portfolio.models.Language;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class UpdatedLanguageDto {
    private Language data;
}
