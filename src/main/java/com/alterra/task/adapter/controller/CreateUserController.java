package com.alterra.task.adapter.controller;

import com.alterra.task.entity.UserEntity;
import com.alterra.task.service.in.CreateUserUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class CreateUserController {

    private final CreateUserUseCase createUserUseCase;

    @PostMapping("/create")
    public UserEntity createUser(@RequestBody UserEntity userEntity) {
        log.info("[JOVAN] /createUser is called");
        return createUserUseCase.createUser(userEntity);
    }

}
