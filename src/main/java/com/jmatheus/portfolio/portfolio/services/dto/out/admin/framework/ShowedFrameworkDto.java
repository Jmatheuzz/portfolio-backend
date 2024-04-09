package com.jmatheus.portfolio.portfolio.services.dto.out.admin.framework;

import com.jmatheus.portfolio.portfolio.models.Framework;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class ShowedFrameworkDto {
    private Framework data;
}
