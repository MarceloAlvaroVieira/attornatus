package com.marcelo.services;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.marcelo.dto.PessoaDTO;
import com.marcelo.model.Pessoa;

@Service
public class PessoaService {
    
    public ResponseEntity<PessoaDTO> create(Pessoa pessoa) {
        return null;
    }

    public ResponseEntity<List<PessoaDTO>> read() {
        return null;
    }

    public ResponseEntity<List<PessoaDTO>> getById(int id) {
        return null;
    }
    
    public ResponseEntity<PessoaDTO> update(int id, Pessoa pessoa) {
        return null;
    }

    public ResponseEntity<Map<String, Boolean>> delete(int id) {
        return null;
    }

}
