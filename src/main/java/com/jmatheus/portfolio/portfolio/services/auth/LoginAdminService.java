package com.jmatheus.portfolio.portfolio.services.auth;

import com.jmatheus.portfolio.portfolio.config.UserDetailsImpl;
import com.jmatheus.portfolio.portfolio.enums.RoleEnum;
import com.jmatheus.portfolio.portfolio.models.User;
import com.jmatheus.portfolio.portfolio.repositories.UserRepository;
import com.jmatheus.portfolio.portfolio.responses.exceptions.Forbidden;
import com.jmatheus.portfolio.portfolio.responses.exceptions.Unauthorized;
import com.jmatheus.portfolio.portfolio.services.dto.in.admin.auth.LoginDto;
import com.jmatheus.portfolio.portfolio.services.dto.out.admin.auth.LoggedDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginAdminService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private UserRepository userRepository;

    public LoggedDto execute (LoginDto data) {
        Optional<User> userFind = userRepository.findByEmail(data.getEmail());
        if (userFind.isEmpty()) throw new Unauthorized("Usuário inexistente ou senha inválida");
        User user = userFind.get();
        if (user.getRole().getName().equals(RoleEnum.ROLE_ADMINISTRATOR)){
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(data.getEmail(), data.getPassword());
            try {
                Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
                UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
                return new LoggedDto(jwtTokenService.generateToken(userDetails));
            } catch (AuthenticationException ex) {
                throw new Unauthorized(ex.getMessage());
            }

        } else {
            throw new Forbidden("Não permitido");
        }

    }
}
