package com.alterra.task.adapter.controller;

import com.alterra.task.entity.AuthenticationRequest;
import com.alterra.task.entity.AuthenticationResponse;
import com.alterra.task.entity.RegisterRequest;
import com.alterra.task.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {

    private final AuthenticationService authenticationService;


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        log.info("[JOVAN] /authenticate is called");
        log.info("[JOVAN] /user" + request);
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
