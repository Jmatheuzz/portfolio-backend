package com.jmatheus.portfolio.portfolio.services.framework;

import com.jmatheus.portfolio.portfolio.models.Framework;
import com.jmatheus.portfolio.portfolio.repositories.FrameworkRepository;
import com.jmatheus.portfolio.portfolio.services.dto.out.admin.framework.ListedFrameworkDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListFrameworkService {
    @Autowired
    FrameworkRepository frameworkRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public ListedFrameworkDto execute(){
        List<Framework> frameworkCreated = frameworkRepository.findAll();
        return new ListedFrameworkDto(frameworkCreated);
    }
}
