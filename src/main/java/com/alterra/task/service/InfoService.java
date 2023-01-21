package com.alterra.task.service;

import com.alterra.task.config.JwtService;
import com.alterra.task.entity.AuthenticationResponse;
import com.alterra.task.entity.InfoResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class InfoService {

    private final JwtService jwtService;


    public InfoResponse extractPhone(@NonNull HttpServletRequest request) {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String userPhone;
        jwt = authHeader.substring(7);
        userPhone = jwtService.extractUsername(jwt);
        return InfoResponse.builder()
                .phone(userPhone)
                .build();
    }
}
