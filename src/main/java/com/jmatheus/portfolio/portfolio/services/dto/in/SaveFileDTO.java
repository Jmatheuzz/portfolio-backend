package com.jmatheus.portfolio.portfolio.services.dto.in;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
public class SaveFileDTO {
    private MultipartFile file;
}

