package com.attornatus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attornatus.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

    Endereco findByLogradouroAndCepAndCidadeAndNumero(String logradouro, String cep, String cidade, int numero);}