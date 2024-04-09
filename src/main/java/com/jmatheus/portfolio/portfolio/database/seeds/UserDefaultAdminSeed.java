package com.jmatheus.portfolio.portfolio.database.seeds;

import com.jmatheus.portfolio.portfolio.enums.RoleEnum;
import com.jmatheus.portfolio.portfolio.models.Role;
import com.jmatheus.portfolio.portfolio.repositories.RoleRepository;
import com.jmatheus.portfolio.portfolio.repositories.UserRepository;
import com.jmatheus.portfolio.portfolio.services.dto.in.admin.CreateDefaultAdminDto;
import com.jmatheus.portfolio.portfolio.services.user.InsertAdminDefaultService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDefaultAdminSeed implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private InsertAdminDefaultService insertUserService;

    @Override
    public void run(String... args) throws Exception {
        seedRoles();
    }

    private void seedRoles() {
        if (userRepository.count() == 0) {
            Optional<Role> roleAdmin = roleRepository.findByName(
                    RoleEnum.ROLE_ADMINISTRATOR
            );
            roleAdmin.ifPresent(role -> insertUserService.execute(new CreateDefaultAdminDto(
                    "Admin",
                    "joaomatheusantunes@gmail.com",
                    "admin",
                    true,
                    role
            )));



        }
    }
}
