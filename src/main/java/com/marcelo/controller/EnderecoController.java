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
    public ResponseEntity<EnderecoDTO> create(@RequestBody EnderecoDTO enderecoDTO){
        return service.create(enderecoDTO);
    }

    @GetMapping()
    public ResponseEntity<List<EnderecoDTO>> read(){
        return service.read();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<EnderecoDTO>> getById(@PathVariable Long id){
        return service.getById(id);    
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoDTO> update(@PathVariable Long id, @RequestBody EnderecoDTO enderecoDTO){
        return service.update(id, enderecoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable Long id){
        return service.delete(id);
    }

}
