package com.alterra.task.controller;

import com.alterra.task.adapter.controller.CreateUserController;
import com.alterra.task.entity.Role;
import com.alterra.task.entity.UserEntity;
import com.alterra.task.service.in.CreateUserUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

import static org.mockito.BDDMockito.given;

@SpringBootTest(classes={CreateUserController.class})
public class TestCreateUserController {
    @Mock
    private  CreateUserUseCase createUserUseCase;

//            = Mockito.mock(CreateUserUseCase.class);

    @InjectMocks
    private CreateUserController createUserController;

    @Test
    void addCountryNoException_WillReturnCorrectResponse(CapturedOutput output) {

        //given
        UserEntity userEntity = new UserEntity();
        userEntity.setName("jovan");
        userEntity.setEmail("jovan");
        userEntity.setPassword("12345678");
        userEntity.setRole(Role.USER);
        UserEntity expectedUser = new UserEntity(
                1, userEntity.getName(), userEntity.getEmail(), userEntity.getPassword(),userEntity.getRole());
        given(createUserUseCase.createUser(userEntity)).willReturn(expectedUser);

        //when
        UserEntity actualResponse = createUserController.createUser(userEntity);

        //then
        assertEquals(expectedUser, actualResponse);
        then(createUserUseCase).should(times(1)).createUser(userEntity);
        assertThat(output).contains("[JOVAN] /createUser is called");

    }

}
