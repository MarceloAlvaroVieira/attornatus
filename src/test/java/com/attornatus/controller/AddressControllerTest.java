package com.attornatus.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.attornatus.dto.AddressDTO;
import com.attornatus.util.DataTest;

/**
 * @SuppressWarnings("null"): the test is intended to fail if it receives a null value
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@SuppressWarnings("null")
public class AddressControllerTest {
    
    @Autowired
    private AddressController controller;

    @Test
    public void teste() { 
        assertAll(  
            () -> assertAll(
                "Create",
                ()-> {
                    ResponseEntity<AddressDTO> addressDTO = controller.create(DataTest.createAddress());
                    assertThat(addressDTO).isNotNull();
                    assertThat(addressDTO.getBody().getStreet())
                        .isEqualTo(DataTest.createAddress().getStreet());
                    assertThat(addressDTO.getStatusCode().toString())
                        .isEqualTo("200 OK");
                }   
            ),
            () -> assertAll(
                "Read",
                ()-> {
                    ResponseEntity<List<AddressDTO>> addressDTO = controller.read();
                    assertThat(addressDTO).isNotNull();
                    assertThat(addressDTO.getBody().toString())
                        .contains(DataTest.createAddress().getStreet());
                    assertThat(addressDTO.getStatusCode().toString())
                        .isEqualTo("200 OK");
                }   
            ),
            () -> assertAll(
                "Find By Id",
                ()-> {
                    ResponseEntity<AddressDTO> addressDTO = controller.getById((long) 1);
                    assertThat(addressDTO).isNotNull();
                    assertThat(addressDTO.getBody().toString())
                        .contains(DataTest.createAddress().getStreet());
                    assertThat(addressDTO.getStatusCode().toString())
                        .isEqualTo("200 OK");
                }   
            ),
            () -> assertAll(
                "Update",
                ()-> {
                    ResponseEntity<AddressDTO> addressDTO = controller.update((long) 1, DataTest.updateAddress());
                    assertThat(addressDTO).isNotNull();
                    assertThat(addressDTO.getBody().getStreet().toString())
                        .isEqualTo(DataTest.updateAddress().getStreet());
                    assertThat(addressDTO.getStatusCode().toString())
                        .isEqualTo("200 OK");
                }   
            ),
            () -> assertAll(
                "Delete",
                ()-> {
                    ResponseEntity<Map<String, Boolean>> addressDTO = controller.delete((long) 1);
                    assertThat(addressDTO).isNotNull();
                    assertThat(addressDTO.getBody().toString())
                        .contains("deleted");
                    assertThat(addressDTO.getStatusCode().toString())
                        .isEqualTo("200 OK");
                }   
            ) 
        );
    }
}
