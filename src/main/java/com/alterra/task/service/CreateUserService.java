package com.alterra.task.service;

import com.alterra.task.entity.UserEntity;
import com.alterra.task.service.in.CreateUserUseCase;
import com.alterra.task.service.out.CreateUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserService implements CreateUserUseCase {
    private final CreateUserPort createUserPort;

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        return createUserPort.createUser(userEntity);
    }
}
