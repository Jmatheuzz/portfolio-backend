package com.jmatheus.portfolio.portfolio.services.language;

import com.jmatheus.portfolio.portfolio.models.Language;
import com.jmatheus.portfolio.portfolio.repositories.LanguageRepository;
import com.jmatheus.portfolio.portfolio.responses.exceptions.BadRequest;
import com.jmatheus.portfolio.portfolio.services.dto.in.admin.language.ShowLanguageDto;
import com.jmatheus.portfolio.portfolio.services.dto.out.admin.language.ShowedLanguageDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShowLanguageService {
    @Autowired
    LanguageRepository languageRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public ShowedLanguageDto execute(ShowLanguageDto data){
        Optional<Language> language = languageRepository.findById(data.getId());
        if (language.isEmpty()) throw new BadRequest("Linguagem não encontrada.");
        return new ShowedLanguageDto(language.get());
    }
}
