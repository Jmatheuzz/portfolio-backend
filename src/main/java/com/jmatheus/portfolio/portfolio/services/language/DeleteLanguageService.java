package com.jmatheus.portfolio.portfolio.services.language;

import com.jmatheus.portfolio.portfolio.models.Language;
import com.jmatheus.portfolio.portfolio.repositories.LanguageRepository;
import com.jmatheus.portfolio.portfolio.responses.exceptions.BadRequest;
import com.jmatheus.portfolio.portfolio.services.dto.in.admin.language.DeleteLanguageDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteLanguageService {
    @Autowired
    LanguageRepository languageRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void execute(DeleteLanguageDto data){
        Optional<Language> languageFind = languageRepository.findById(data.getId());
        if (languageFind.isEmpty()) throw new BadRequest("Linguagem não encontrada.");
        languageRepository.delete(languageFind.get());
    }
}
