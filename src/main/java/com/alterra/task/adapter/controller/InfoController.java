package com.alterra.task.adapter.controller;

import com.alterra.task.entity.AuthenticationRequest;
import com.alterra.task.entity.AuthenticationResponse;
import com.alterra.task.entity.InfoResponse;
import com.alterra.task.service.InfoService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2/auth")
@RequiredArgsConstructor
@Slf4j
public class InfoController {
    private final InfoService infoService;

    @GetMapping("/info")
    public ResponseEntity<InfoResponse> authenticate(@NonNull HttpServletRequest request
    ) {
        log.info("[JOVAN] /authenticate is called");
        return ResponseEntity.ok(infoService.extractPhone(request));
    }

}
