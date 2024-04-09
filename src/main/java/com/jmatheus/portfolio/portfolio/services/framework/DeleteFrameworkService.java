package com.jmatheus.portfolio.portfolio.services.framework;

import com.jmatheus.portfolio.portfolio.models.Framework;
import com.jmatheus.portfolio.portfolio.repositories.FrameworkRepository;
import com.jmatheus.portfolio.portfolio.responses.exceptions.BadRequest;
import com.jmatheus.portfolio.portfolio.services.dto.in.admin.framework.DeleteFrameworkDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteFrameworkService {
    @Autowired
    FrameworkRepository frameworkRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void execute(DeleteFrameworkDto data){
        Optional<Framework> frameworkFind = frameworkRepository.findById(data.getId());
        if (frameworkFind.isEmpty()) throw new BadRequest("Framework não encontrado.");
        frameworkRepository.delete(frameworkFind.get());
    }
}
