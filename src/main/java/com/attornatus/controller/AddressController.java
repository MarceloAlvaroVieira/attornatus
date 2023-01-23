package com.attornatus.controller;

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

import com.attornatus.dto.AddressDTO;
import com.attornatus.services.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
    
    @Autowired
    private AddressService service;

    @PostMapping()
    public ResponseEntity<AddressDTO> create(@RequestBody AddressDTO addressDTO){
        return service.create(addressDTO);
    }

    @GetMapping()
    public ResponseEntity<List<AddressDTO>> read(){
        return service.read();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> getById(@PathVariable Long id){
        return service.getById(id);    
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressDTO> update(@PathVariable Long id, @RequestBody AddressDTO addressDTO){
        return service.update(id, addressDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable Long id){
        return service.delete(id);
    }

}
