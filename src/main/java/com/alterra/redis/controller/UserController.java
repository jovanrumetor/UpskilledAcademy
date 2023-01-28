package com.alterra.redis.controller;

import com.alterra.redis.entity.UserEntity;
import com.alterra.redis.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    @Autowired(required = false)
    UserService userService;

    @PostMapping("/create")
    public UserEntity createUser(@RequestBody UserEntity userEntity) {
        log.info("[JOVAN] /createUser is called");
        return userService.createUser(userEntity);
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getMentors() {
            ResponseEntity<List<UserEntity>> response = new ResponseEntity<>(userService.getusers(), HttpStatus.OK);
            log.info("[JOVAN] response length is: "+ response.getBody().size());
            return response;
    }

}
