package com.attornatus.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.attornatus.dto.UserDTO;
import com.attornatus.util.DataTest;

/*
 * @SuppressWarnings("null"): the test is intended to fail if it receives a null value
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@SuppressWarnings("null")
public class UserControllerTest {

    @Autowired
    private UserController controller;

    @Test
    public void teste() { 
        assertAll(
            () -> assertAll(
                "Create",
                ()-> {
                    ResponseEntity<UserDTO> userDTO = controller.create(DataTest.createUser());
                    assertThat(userDTO).isNotNull();
                    assertThat(userDTO.getBody().getName())
                        .isEqualTo(DataTest.createUser().getName());
                    assertThat(userDTO.getStatusCode().toString())
                        .isEqualTo("200 OK");
                }   
            ),
            () -> assertAll(
                "Read",
                ()-> {
                    ResponseEntity<List<UserDTO>> userDTO = controller.read();
                    assertThat(userDTO).isNotNull();
                    assertThat(userDTO.getBody().toString())
                        .contains(DataTest.createUser().getName());
                    assertThat(userDTO.getStatusCode().toString())
                        .isEqualTo("200 OK");
                }   
            ),
            () -> assertAll(
                "Find By Id",
                ()-> {
                    ResponseEntity<UserDTO> userDTO = controller.getById((long) 1L);
                    assertThat(userDTO).isNotNull();
                    assertThat(userDTO.getBody().toString())
                        .contains(DataTest.createUser().getName());
                    assertThat(userDTO.getStatusCode().toString())
                        .isEqualTo("200 OK");
                }   
            ),
            () -> assertAll(
                "Update",
                ()-> {
                    ResponseEntity<UserDTO> userDTO = controller.update((long) 1L, DataTest.updateUser());
                    assertThat(userDTO).isNotNull();
                    assertThat(userDTO.getBody().getName().toString())
                        .isEqualTo(DataTest.updateUser().getName());
                    assertThat(userDTO.getStatusCode().toString())
                        .isEqualTo("200 OK");
                }   
            ),  
            () -> assertAll(
                "Delete",
                ()-> {
                    ResponseEntity<Map<String, Boolean>> userDTO = controller.delete((long) 1);
                    assertThat(userDTO).isNotNull();
                    assertThat(userDTO.getBody().toString())
                        .contains("deleted");
                    assertThat(userDTO.getStatusCode().toString())
                        .isEqualTo("200 OK");
                }   
            ) 
        );
    }
}