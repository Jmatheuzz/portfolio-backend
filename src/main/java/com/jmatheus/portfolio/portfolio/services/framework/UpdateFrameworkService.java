package com.jmatheus.portfolio.portfolio.services.framework;

import com.jmatheus.portfolio.portfolio.models.Framework;
import com.jmatheus.portfolio.portfolio.repositories.FrameworkRepository;
import com.jmatheus.portfolio.portfolio.responses.exceptions.BadRequest;
import com.jmatheus.portfolio.portfolio.services.dto.in.admin.framework.UpdateFrameworkDto;
import com.jmatheus.portfolio.portfolio.services.dto.out.admin.framework.UpdatedFrameworkDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateFrameworkService {
    @Autowired
    FrameworkRepository frameworkRepository;

    @Autowired
    private ModelMapper modelMapper;

    public UpdatedFrameworkDto execute(UpdateFrameworkDto data){
        Optional<Framework> frameworkFind = frameworkRepository.findById(data.getId());
        if (frameworkFind.isEmpty()) throw new BadRequest("Framework não encontrado.");
        Framework framework = frameworkFind.get();
        framework.setName(data.getName());
        frameworkRepository.save(framework);
        return new UpdatedFrameworkDto(framework);
    }
}
