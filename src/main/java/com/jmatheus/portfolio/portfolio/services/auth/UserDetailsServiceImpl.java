package com.jmatheus.portfolio.portfolio.services.auth;

import com.jmatheus.portfolio.portfolio.config.UserDetailsImpl;
import com.jmatheus.portfolio.portfolio.models.User;
import com.jmatheus.portfolio.portfolio.repositories.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(username);
        if (user.isEmpty()) throw new UsernameNotFoundException("Usuário não encontrado.");
        return new UserDetailsImpl(user.get());
    }

}
