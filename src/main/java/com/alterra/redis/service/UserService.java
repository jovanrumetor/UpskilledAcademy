package com.alterra.redis.service;

import com.alterra.redis.config.JwtService;
import com.alterra.redis.entity.Role;
import com.alterra.redis.entity.UserEntity;
import com.alterra.redis.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;


    public List<UserEntity> getusers() { return (List<UserEntity>) userRepository.findAll(); }


    public UserEntity createUser(UserEntity userEntity) {
        var user = UserEntity.builder()
                .name(userEntity.getName())
                .email(userEntity.getEmail())
                .phone(userEntity.getPhone())
                .password(passwordEncoder.encode(userEntity.getPassword()))
                .role(Role.USER)
                .build();
        return userRepository.save(user);
    }

}
