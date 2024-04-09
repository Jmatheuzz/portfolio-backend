package com.jmatheus.portfolio.portfolio.config;

import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.jmatheus.portfolio.portfolio.models.User;
import com.jmatheus.portfolio.portfolio.repositories.UserRepository;
import com.jmatheus.portfolio.portfolio.responses.exceptions.BodySecurityException;
import com.jmatheus.portfolio.portfolio.services.auth.JwtTokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class UserAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {
            if (checkIfEndpointIsNotPublic(request)) {
                String token = recoveryToken(request);
                if (token != null) {
                    String subject = jwtTokenService.getSubjectFromToken(token);
                    Optional<User> user = userRepository.findByEmail(subject);
                    if (user.isEmpty()) throw new BadCredentialsException("Token inválido");
                    UserDetailsImpl userDetails = new UserDetailsImpl(user.get());
                    Authentication authentication =
                            new UsernamePasswordAuthenticationToken(userDetails.getUsername(), null, userDetails.getAuthorities());


                    SecurityContextHolder.getContext().setAuthentication(authentication);

                } else {
                    throw new BadCredentialsException("O token está ausente.");
                }
            }

            filterChain.doFilter(request, response);
        } catch (BadCredentialsException ex) {
            String message = BodySecurityException.create(response, ex.getMessage());
            response.getWriter().println(message);
        } catch (JWTVerificationException ex) {
            String message = BodySecurityException.create(response, "Token inválido ou expirado");
            response.getWriter().println(message);
        } catch (JWTCreationException ex) {
            String message = BodySecurityException.create(response, "Erro ao gerar token");
            response.getWriter().println(message);
        } catch (Exception ex) {
            String message = BodySecurityException.create(response, "Não permitido");
            response.getWriter().println(message);
        }

    }


    private String recoveryToken(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null) {
            return authorizationHeader.replace("Bearer ", "");
        }
        return null;
    }


    private boolean checkIfEndpointIsNotPublic(HttpServletRequest request) {

        String requestURI = request.getRequestURI();
        boolean isNotPublic = true;
        for(String endpoint : SecurityConfig.ENDPOINTS_WITH_AUTHENTICATION_NOT_REQUIRED){
            if (requestURI.contains(endpoint)) {
                isNotPublic = false;
                break;
            }
        }
        return isNotPublic;
    }

}
