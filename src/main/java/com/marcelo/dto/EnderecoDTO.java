package com.marcelo.dto;

import com.marcelo.model.Endereco;

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

    public EnderecoDTO fromEndereco(Endereco endereco){
        return new EnderecoDTO(
            endereco.getId(),
            endereco.getLogradouro(),
            endereco.getCep(),
            endereco.getNumero(),
            endereco.getCidade()
        );
    }

    public Endereco toEndereco(){
        return new Endereco(
            this.getId(),
            this.getLogradouro(),
            this.getCep(),
            this.getNumero(),
            this.getCidade()
        );
    }
}
