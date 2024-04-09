package com.jmatheus.portfolio.portfolio.database.seeds;

import com.jmatheus.portfolio.portfolio.enums.RoleEnum;
import com.jmatheus.portfolio.portfolio.models.Role;
import com.jmatheus.portfolio.portfolio.repositories.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RoleSeed implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void run(String... args) throws Exception {
        seedRoles();
    }

    private void seedRoles() {
        if (roleRepository.count() == 0) {
            Role roleCustomer = new Role(1, RoleEnum.ROLE_CUSTOMER);
            roleRepository.save(modelMapper.map(roleCustomer, Role.class));

            Role roleAdmin = new Role();
            roleAdmin.setId(2);
            roleAdmin.setName(RoleEnum.ROLE_ADMINISTRATOR);
            roleRepository.save(modelMapper.map(roleAdmin, Role.class));


        }
    }
}
