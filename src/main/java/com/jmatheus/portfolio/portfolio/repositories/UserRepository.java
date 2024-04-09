package com.jmatheus.portfolio.portfolio.repositories;

import com.jmatheus.portfolio.portfolio.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndCode(String email, String code);

    void deleteByEmail(String email);
}
