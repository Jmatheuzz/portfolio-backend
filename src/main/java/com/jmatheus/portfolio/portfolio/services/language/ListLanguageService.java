package com.jmatheus.portfolio.portfolio.services.language;

import com.jmatheus.portfolio.portfolio.models.Language;
import com.jmatheus.portfolio.portfolio.repositories.LanguageRepository;
import com.jmatheus.portfolio.portfolio.services.dto.out.admin.language.ListedLanguageDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListLanguageService {
    @Autowired
    LanguageRepository languageRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public ListedLanguageDto execute(){
        List<Language> languageCreated = languageRepository.findAll();
        return new ListedLanguageDto(languageCreated);
    }
}
