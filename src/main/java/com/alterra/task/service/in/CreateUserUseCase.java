package com.alterra.task.service.in;

import com.alterra.task.entity.UserEntity;

public interface CreateUserUseCase {
    UserEntity createUser(UserEntity userEntity);
}
