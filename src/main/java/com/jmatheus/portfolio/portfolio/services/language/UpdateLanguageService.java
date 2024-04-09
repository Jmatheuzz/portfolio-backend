package com.jmatheus.portfolio.portfolio.services.language;

import com.jmatheus.portfolio.portfolio.models.Language;
import com.jmatheus.portfolio.portfolio.repositories.LanguageRepository;
import com.jmatheus.portfolio.portfolio.responses.exceptions.BadRequest;
import com.jmatheus.portfolio.portfolio.services.dto.in.admin.language.UpdateLanguageDto;
import com.jmatheus.portfolio.portfolio.services.dto.out.admin.language.UpdatedLanguageDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateLanguageService {
    @Autowired
    LanguageRepository languageRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UpdatedLanguageDto execute(UpdateLanguageDto data){
        Optional<Language> languageFind = languageRepository.findById(data.getId());
        if (languageFind.isEmpty()) throw new BadRequest("Linguagem não encontrada.");
        Language language = languageFind.get();
        language.setName(data.getName());
        languageRepository.save(language);
        return new UpdatedLanguageDto(language);
    }
}
