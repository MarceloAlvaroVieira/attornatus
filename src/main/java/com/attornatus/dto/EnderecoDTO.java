package com.attornatus.dto;

import com.attornatus.model.Endereco;

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

    public EnderecoDTO(Endereco endereco){
        this.id = endereco.getId();
        this.logradouro = endereco.getLogradouro();
        this.cep = endereco.getCep();
        this.numero = endereco.getNumero();
        this.cidade = endereco.getCidade();
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
