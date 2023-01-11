package com.marcelo.services;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.marcelo.dto.EnderecoDTO;
import com.marcelo.model.Endereco;

@Service
public class EnderecoService {

    public ResponseEntity<EnderecoDTO> create(Endereco endereco) {
        return null;
    }

    public ResponseEntity<List<EnderecoDTO>> read() {
        return null;
    }

    public ResponseEntity<List<EnderecoDTO>> getById(int id) {
        return null;
    }
    
    public ResponseEntity<EnderecoDTO> update(int id, Endereco endereco) {
        return null;
    }

    public ResponseEntity<Map<String, Boolean>> delete(int id) {
        return null;
    }
    
}
