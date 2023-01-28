package com.alterra.redis.controller;

import com.alterra.redis.entity.AuthenticationRequest;
import com.alterra.redis.entity.AuthenticationResponse;
import com.alterra.redis.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {

    private final AuthenticationService authenticationService;


    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        log.info("[JOVAN] /login is called");
        log.info("[JOVAN] /user" + request);
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
