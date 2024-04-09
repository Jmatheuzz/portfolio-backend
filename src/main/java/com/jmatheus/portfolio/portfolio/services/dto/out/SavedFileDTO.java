package com.jmatheus.portfolio.portfolio.services.dto.out;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class SavedFileDTO {
    private Long id;
    private String filename;
    private String type;
}
