package com.attornatus.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.attornatus.dto.EnderecoDTO;
import com.attornatus.util.DataTest;

/**
 * @SuppressWarnings("null") utilizado pois, o teste tem a intenção de falhar
 * caso receba um valor nulo
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@SuppressWarnings("null")
public class EnderecoControllerTest {
    
    @Autowired
    private EnderecoController controller;

    @Test
    public void teste() { 
        assertAll(  
            () -> assertAll(
                "Create",
                ()-> {
                    ResponseEntity<EnderecoDTO> enderecoDTO = controller.create(DataTest.createEndereco());
                    assertThat(enderecoDTO).isNotNull();
                    assertThat(enderecoDTO.getBody().getLogradouro())
                        .isEqualTo(DataTest.createEndereco().getLogradouro());
                    assertThat(enderecoDTO.getStatusCode().toString())
                        .isEqualTo("200 OK");
                }   
            ),
            () -> assertAll(
                "Read",
                ()-> {
                    ResponseEntity<List<EnderecoDTO>> enderecoDTO = controller.read();
                    assertThat(enderecoDTO).isNotNull();
                    assertThat(enderecoDTO.getBody().toString())
                        .contains(DataTest.createEndereco().getLogradouro());
                    assertThat(enderecoDTO.getStatusCode().toString())
                        .isEqualTo("200 OK");
                }   
            ),
            () -> assertAll(
                "Find By Id",
                ()-> {
                    ResponseEntity<EnderecoDTO> enderecoDTO = controller.getById((long) 1);
                    assertThat(enderecoDTO).isNotNull();
                    assertThat(enderecoDTO.getBody().toString())
                        .contains(DataTest.createEndereco().getLogradouro());
                    assertThat(enderecoDTO.getStatusCode().toString())
                        .isEqualTo("200 OK");
                }   
            ),
            () -> assertAll(
                "Update",
                ()-> {
                    ResponseEntity<EnderecoDTO> enderecoDTO = controller.update((long) 1, DataTest.updateEndereco());
                    assertThat(enderecoDTO).isNotNull();
                    assertThat(enderecoDTO.getBody().getLogradouro().toString())
                        .isEqualTo(DataTest.updateEndereco().getLogradouro());
                    assertThat(enderecoDTO.getStatusCode().toString())
                        .isEqualTo("200 OK");
                }   
            ),
            () -> assertAll(
                "Delete",
                ()-> {
                    ResponseEntity<Map<String, Boolean>> enderecoDTO = controller.delete((long) 1);
                    assertThat(enderecoDTO).isNotNull();
                    assertThat(enderecoDTO.getBody().toString())
                        .contains("deleted");
                    assertThat(enderecoDTO.getStatusCode().toString())
                        .isEqualTo("200 OK");
                }   
            ) 
        );
    }
}
