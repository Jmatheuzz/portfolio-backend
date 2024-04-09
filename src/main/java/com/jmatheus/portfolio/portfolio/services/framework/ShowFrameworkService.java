package com.jmatheus.portfolio.portfolio.services.framework;

import com.jmatheus.portfolio.portfolio.models.Framework;
import com.jmatheus.portfolio.portfolio.repositories.FrameworkRepository;
import com.jmatheus.portfolio.portfolio.responses.exceptions.BadRequest;
import com.jmatheus.portfolio.portfolio.services.dto.in.admin.framework.ShowFrameworkDto;
import com.jmatheus.portfolio.portfolio.services.dto.out.admin.framework.ShowedFrameworkDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShowFrameworkService {
    @Autowired
    FrameworkRepository frameworkRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public ShowedFrameworkDto execute(ShowFrameworkDto data){
        Optional<Framework> framework = frameworkRepository.findById(data.getId());
        if (framework.isEmpty()) throw new BadRequest("Framework não encontrado.");
        return new ShowedFrameworkDto(framework.get());
    }
}
