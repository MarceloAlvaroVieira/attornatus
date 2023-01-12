package com.marcelo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.marcelo.dto.PessoaDTO;
import com.marcelo.exception.ResourceNotFoundException;
import com.marcelo.model.Pessoa;
import com.marcelo.repository.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository repository;

    public ResponseEntity<PessoaDTO> create(PessoaDTO pessoaDTO) {
        Pessoa pessoa = repository.save(pessoaDTO.toPessoa());
        return ResponseEntity.ok(new PessoaDTO().fromPessoa(pessoa));
    }

    public ResponseEntity<List<PessoaDTO>> read() {

        List<Pessoa> pessoas = repository.findAll();
        List<PessoaDTO> pessoasDTO = new ArrayList<>();

        pessoas.forEach((pessoa) -> {
            pessoasDTO.add(new PessoaDTO().fromPessoa(pessoa));
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

}
