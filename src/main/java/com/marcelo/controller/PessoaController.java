package com.marcelo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.marcelo.dto.PessoaDTO;
import com.marcelo.model.Pessoa;
import com.marcelo.services.PessoaService;

public class PessoaController {
    
    @Autowired
    private PessoaService service;

    @PostMapping()
    public ResponseEntity<PessoaDTO> create(@RequestBody Pessoa pessoa){
        return service.create(pessoa);
    }

    @GetMapping()
    public ResponseEntity<List<PessoaDTO>> read(){
        return service.read();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<PessoaDTO>> getById(@PathVariable int id){
        return service.getById(id);    
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaDTO> update(@PathVariable int id, @RequestBody Pessoa pessoa){
        return service.update(id, pessoa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable int id){
        return service.delete(id);
    }
    
}
