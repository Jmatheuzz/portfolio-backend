package com.jmatheus.portfolio.portfolio.repositories;

import com.jmatheus.portfolio.portfolio.enums.RoleEnum;
import com.jmatheus.portfolio.portfolio.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleEnum name);

}
