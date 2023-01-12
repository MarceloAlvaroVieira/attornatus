package com.marcelo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.marcelo.dto.EnderecoDTO;
import com.marcelo.exception.ResourceNotFoundException;
import com.marcelo.model.Endereco;
import com.marcelo.repository.EnderecoRepository;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository repository;

    public ResponseEntity<EnderecoDTO> create(EnderecoDTO enderecoDTO) {
        Endereco endereco = repository.save(enderecoDTO.toEndereco());
        return ResponseEntity.ok(new EnderecoDTO().fromEndereco(endereco));
    }

    public ResponseEntity<List<EnderecoDTO>> read() {

        List<Endereco> enderecos = repository.findAll();
        List<EnderecoDTO> enderecosDTO = new ArrayList<>();

        enderecos.forEach((endereco) -> {
            enderecosDTO.add(new EnderecoDTO().fromEndereco(endereco));
        });

        return ResponseEntity.ok(enderecosDTO);
    }

    public ResponseEntity<EnderecoDTO> getById(Long id) {

        Endereco endereco = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Endereco não encontrado"));

        return ResponseEntity.ok(new EnderecoDTO().fromEndereco(endereco));
    }

    public ResponseEntity<EnderecoDTO> update(Long id, EnderecoDTO enderecoDTO) {

        Endereco endereco = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Endereco não encontrado"));

        endereco = repository.save(enderecoDTO.toEndereco());

        return ResponseEntity.ok(new EnderecoDTO().fromEndereco(endereco));
    }

    public ResponseEntity<Map<String, Boolean>> delete(Long id) {

        Endereco endereco = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Endereco não encontrado"));

        repository.delete(endereco);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

}
