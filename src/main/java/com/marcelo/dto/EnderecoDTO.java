package com.marcelo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {
    private long id;
    private String logradouro;
    private String cep;
    private int numero;
    private String cidade;
}
