package com.alterra.task.service;

import com.alterra.task.adapter.persistence.UserRepository;
import com.alterra.task.config.JwtService;
import com.alterra.task.entity.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;


    public AuthenticationResponse authenticate(AuthenticationRequest request){
        try {
            log.info("[JOVAN] /auth req" + request);
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getPhone(),
                            request.getPassword()
                    )
            );
            log.info("[JOVAN] /authenticationManager is called");
            var user = userRepository.findByPhone(request.getPhone())
                    .orElseThrow();
            log.info("[JOVAN] /user is" + user);
            var jwtToken = jwtService.generateToken(user);
            log.info("[JOVAN] /jwtToken is" + jwtToken);
            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .build();
        }catch (Exception e){
            log.info("[JOVAN] /error is " + e);
            return AuthenticationResponse.builder().build();
        }
    }

}
