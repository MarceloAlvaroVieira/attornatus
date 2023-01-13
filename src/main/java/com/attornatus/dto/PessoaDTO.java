package com.attornatus.dto;

import java.io.Serializable;
import java.sql.Date;

import com.attornatus.model.Endereco;
import com.attornatus.model.Pessoa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO implements Serializable{

    static private final long serialVersionUID=1L;

    private long id;
    private String nome;
    private Date dataNascimento;
    private Endereco endereco;

    public PessoaDTO(Pessoa pessoa){
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.dataNascimento = pessoa.getDataNascimento();
        this.endereco = pessoa.getEndereco();
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
