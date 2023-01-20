package com.alterra.task.service.out;

import com.alterra.task.entity.UserEntity;

public interface CreateUserPort {

    UserEntity createUser(UserEntity userEntity);
}
