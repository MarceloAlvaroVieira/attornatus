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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcelo.dto.EnderecoDTO;
import com.marcelo.model.Endereco;
import com.marcelo.services.EnderecoService;

@RestController
@RequestMapping("/")
public class EnderecoController {
    
    @Autowired
    private EnderecoService service;

    @PostMapping()
    public ResponseEntity<EnderecoDTO> create(@RequestBody Endereco endereco){
        return service.create(endereco);
    }

    @GetMapping()
    public ResponseEntity<List<EnderecoDTO>> read(){
        return service.read();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<EnderecoDTO>> getById(@PathVariable int id){
        return service.getById(id);    
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoDTO> update(@PathVariable int id, @RequestBody Endereco endereco){
        return service.update(id, endereco);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable int id){
        return service.delete(id);
    }

}
