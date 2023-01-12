package com.attornatus.dto;

import java.sql.Date;

import com.attornatus.model.Endereco;
import com.attornatus.model.Pessoa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {
    private long id;
    private String nome;
    private Date dataNascimento;
    private Endereco endereco;

    public PessoaDTO fromPessoa(Pessoa pessoa){
        return new PessoaDTO(
            pessoa.getId(),
            pessoa.getNome(),
            pessoa.getDataNascimento(),
            pessoa.getEndereco()
        );
    }

    public Pessoa toPessoa(){
        return new Pessoa(
            this.getId(),
            this.getNome(),
            this.getDataNascimento(),
            this.getEndereco()
        );
    }
}
