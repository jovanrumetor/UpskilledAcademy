package com.alterra.task.adapter.persistence;

import com.alterra.task.config.JwtService;
import com.alterra.task.entity.AuthenticationResponse;
import com.alterra.task.entity.Role;
import com.alterra.task.entity.UserEntity;
import com.alterra.task.service.out.CreateUserPort;
import com.alterra.task.service.out.GetAllUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserPersistence implements CreateUserPort, GetAllUserPort {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public List<UserEntity> getAllUser() {
        return userRepository.findAll();
    }


    @Override
    public UserEntity createUser(UserEntity userEntity) {
        var user = UserEntity.builder()
                .name(userEntity.getName())
                .email(userEntity.getEmail())
                .password(passwordEncoder.encode(userEntity.getPassword()))
                .role(Role.USER)
                .build();
        return userRepository.save(user);
    }



}
