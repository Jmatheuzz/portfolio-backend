package com.jmatheus.portfolio.portfolio.services.language;

import com.jmatheus.portfolio.portfolio.models.Language;
import com.jmatheus.portfolio.portfolio.repositories.LanguageRepository;
import com.jmatheus.portfolio.portfolio.services.dto.in.admin.language.CreateLanguageDto;
import com.jmatheus.portfolio.portfolio.services.dto.out.admin.language.CreatedLanguageDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class InsertLanguageService {
    @Autowired
    LanguageRepository languageRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public CreatedLanguageDto execute(CreateLanguageDto language){
        Language data = modelMapper.map(language, Language.class);
        Language languageCreated = languageRepository.save(data);
        return modelMapper.map(languageCreated, CreatedLanguageDto.class);
    }
}
