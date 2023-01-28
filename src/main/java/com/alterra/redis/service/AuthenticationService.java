package com.alterra.redis.service;

import com.alterra.redis.config.JwtService;
import com.alterra.redis.entity.AuthenticationRequest;
import com.alterra.redis.entity.AuthenticationResponse;
import com.alterra.redis.repository.UserRepository;
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
                            request.getEmail(),
                            request.getPassword()
                    )
            );
            log.info("[JOVAN] /authenticationManager is called");
            var user = userRepository.findByEmail(request.getEmail())
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
