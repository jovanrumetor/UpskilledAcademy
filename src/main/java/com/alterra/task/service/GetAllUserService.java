package com.alterra.task.service;

import com.alterra.task.entity.UserEntity;
import com.alterra.task.service.in.GetAllUserUseCase;
import com.alterra.task.service.out.GetAllUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllUserService implements GetAllUserUseCase {

    private final GetAllUserPort getAllUserPort;

    @Override
    public List<UserEntity> getAllUser() {
        return getAllUserPort.getAllUser();
    }
}
