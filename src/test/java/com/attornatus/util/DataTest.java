package com.attornatus.util;

import java.sql.Date;

import com.attornatus.dto.EnderecoDTO;
import com.attornatus.dto.PessoaDTO;
import com.attornatus.model.Endereco;
import com.attornatus.model.Pessoa;

public class DataTest {
   
    static Endereco endereco = new Endereco(null, "Centro", "35555000", 317, "Camacho");
    static Pessoa pessoa = new Pessoa(1L, "Marcelo", Date.valueOf("2003-03-13"), endereco);
   
    public static PessoaDTO createPessoa(){
        return new PessoaDTO(pessoa);
    }   

    public static PessoaDTO updatePessoa(){
        PessoaDTO pessoaDTO = new PessoaDTO(pessoa);
        pessoaDTO.setId(1L);
        pessoaDTO.setNome("Marcelo Álvaro");
        return pessoaDTO;
    } 

    public static EnderecoDTO createEndereco(){
        endereco.setId(1L);
        return new EnderecoDTO(endereco);
    }   

    public static EnderecoDTO updateEndereco(){
        EnderecoDTO enderecoDTO = new EnderecoDTO(endereco);
        enderecoDTO.setId(1L);
        enderecoDTO.setLogradouro("Logradouro");
        return enderecoDTO;
    } 
}
