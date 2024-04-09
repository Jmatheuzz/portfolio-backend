package com.jmatheus.portfolio.portfolio.services.framework;

import com.jmatheus.portfolio.portfolio.models.Framework;
import com.jmatheus.portfolio.portfolio.repositories.FrameworkRepository;
import com.jmatheus.portfolio.portfolio.services.dto.in.admin.framework.CreateFrameworkDto;
import com.jmatheus.portfolio.portfolio.services.dto.out.admin.framework.CreatedFrameworkDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class InsertFrameworkService {
    @Autowired
    FrameworkRepository frameworkRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public CreatedFrameworkDto execute(CreateFrameworkDto framework){
        Framework data = modelMapper.map(framework, Framework.class);
        Framework frameworkCreated = frameworkRepository.save(data);
        return modelMapper.map(frameworkCreated, CreatedFrameworkDto.class);
    }
}
