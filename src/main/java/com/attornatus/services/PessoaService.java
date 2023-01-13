package com.attornatus.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.attornatus.dto.PessoaDTO;
import com.attornatus.exception.ResourceNotFoundException;
import com.attornatus.model.Endereco;
import com.attornatus.model.Pessoa;
import com.attornatus.repository.EnderecoRepository;
import com.attornatus.repository.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository repository;

    @Autowired
    EnderecoRepository enderecoRepository;

    public ResponseEntity<PessoaDTO> create(PessoaDTO pessoaDTO) {

        pessoaDTO.setEndereco(findEndereco(pessoaDTO.getEndereco()));

        Pessoa pessoa = repository.save(pessoaDTO.toPessoa());
        return ResponseEntity.ok(new PessoaDTO().fromPessoa(pessoa));
    }

    public ResponseEntity<List<PessoaDTO>> read() {

        List<Pessoa> pessoas = repository.findAll();
        List<PessoaDTO> pessoasDTO = new ArrayList<>();

        System.out.println(pessoas);

        pessoas.forEach((pessoa) -> {
            PessoaDTO pessoaDTO = new PessoaDTO().fromPessoa(pessoa);
            System.out.println(pessoaDTO);
            pessoasDTO.add(pessoaDTO);
        });

        return ResponseEntity.ok(pessoasDTO);
    }

    public ResponseEntity<PessoaDTO> getById(Long id) {

        Pessoa pessoa = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada"));

        return ResponseEntity.ok(new PessoaDTO().fromPessoa(pessoa));
    }

    public ResponseEntity<PessoaDTO> update(Long id, PessoaDTO pessoaDTO) {

        Pessoa pessoa = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada"));

        pessoa = repository.save(pessoaDTO.toPessoa());

        return ResponseEntity.ok(new PessoaDTO().fromPessoa(pessoa));
    }

    public ResponseEntity<Map<String, Boolean>> delete(Long id) {

        Pessoa pessoa = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada"));

        repository.delete(pessoa);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

    /*
     * Verifica a existência do endereco na base de dados e o cria, caso não exista
     */
    private Endereco findEndereco(Endereco endereco){
        Long id = endereco.getId();
        
        if(id != null)
            endereco = enderecoRepository.findById(id).orElse(null);

        if(endereco == null){
            endereco = enderecoRepository.save(endereco);
        }

        return endereco;
    }

}
