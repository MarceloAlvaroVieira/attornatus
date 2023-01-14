package com.attornatus.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.attornatus.dto.PessoaDTO;
import com.attornatus.util.DataTest;

/**
 * @SuppressWarnings("null") utilizado pois, o teste tem a intenção de falhar
 * caso receba um valor nulo
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@SuppressWarnings("null")
public class PessoaControllerTest {

    @Autowired
    private PessoaController controller;

    @Test
    public void teste() { 
        assertAll(
            () -> assertAll(
                "Create",
                ()-> {
                    ResponseEntity<PessoaDTO> pessoaDTO = controller.create(DataTest.createPessoa());
                    assertThat(pessoaDTO).isNotNull();
                    assertThat(pessoaDTO.getBody().getNome())
                        .isEqualTo(DataTest.createPessoa().getNome());
                    assertThat(pessoaDTO.getStatusCode().toString())
                        .isEqualTo("200 OK");
                }   
            ),
            () -> assertAll(
                "Read",
                ()-> {
                    ResponseEntity<List<PessoaDTO>> pessoaDTO = controller.read();
                    assertThat(pessoaDTO).isNotNull();
                    assertThat(pessoaDTO.getBody().toString())
                        .contains(DataTest.createPessoa().getNome());
                    assertThat(pessoaDTO.getStatusCode().toString())
                        .isEqualTo("200 OK");
                }   
            ),
            () -> assertAll(
                "Find By Id",
                ()-> {
                    ResponseEntity<PessoaDTO> pessoaDTO = controller.getById((long) 1L);
                    assertThat(pessoaDTO).isNotNull();
                    assertThat(pessoaDTO.getBody().toString())
                        .contains(DataTest.createPessoa().getNome());
                    assertThat(pessoaDTO.getStatusCode().toString())
                        .isEqualTo("200 OK");
                }   
            ),
            () -> assertAll(
                "Update",
                ()-> {
                    ResponseEntity<PessoaDTO> pessoaDTO = controller.update((long) 1L, DataTest.updatePessoa());
                    assertThat(pessoaDTO).isNotNull();
                    assertThat(pessoaDTO.getBody().getNome().toString())
                        .isEqualTo(DataTest.updatePessoa().getNome());
                    assertThat(pessoaDTO.getStatusCode().toString())
                        .isEqualTo("200 OK");
                }   
            ),  
            () -> assertAll(
                "Delete",
                ()-> {
                    ResponseEntity<Map<String, Boolean>> pessoaDTO = controller.delete((long) 1);
                    assertThat(pessoaDTO).isNotNull();
                    assertThat(pessoaDTO.getBody().toString())
                        .contains("deleted");
                    assertThat(pessoaDTO.getStatusCode().toString())
                        .isEqualTo("200 OK");
                }   
            ) 
        );
    }
}