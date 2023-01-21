package com.alterra.task.service.in;

import com.alterra.task.entity.UserEntity;

import java.util.List;

public interface GetAllUserUseCase {

    List<UserEntity> getAllUser();
}
