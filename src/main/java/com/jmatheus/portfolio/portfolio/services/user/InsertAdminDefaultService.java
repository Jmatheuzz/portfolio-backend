package com.jmatheus.portfolio.portfolio.services.user;

import com.jmatheus.portfolio.portfolio.models.User;
import com.jmatheus.portfolio.portfolio.repositories.UserRepository;
import com.jmatheus.portfolio.portfolio.services.dto.in.admin.CreateDefaultAdminDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class InsertAdminDefaultService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void execute(CreateDefaultAdminDto user){
        User data = modelMapper.map(user, User.class);
        data.setPassword(passwordEncoder.encode(data.getPassword()));
        User userCreated = userRepository.save(data);
    }
}
