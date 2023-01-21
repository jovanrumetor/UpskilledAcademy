package com.alterra.task.adapter.controller;

import com.alterra.task.entity.UserEntity;
import com.alterra.task.service.in.GetAllUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class GetAllUserController {

    private final GetAllUserUseCase getAllUserUseCase;

    @GetMapping
    public List<UserEntity> getAllUser () {
        return getAllUserUseCase.getAllUser();
    }

}
