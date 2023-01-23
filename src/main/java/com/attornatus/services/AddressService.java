package com.attornatus.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.attornatus.dto.AddressDTO;
import com.attornatus.exception.ResourceNotFoundException;
import com.attornatus.model.Address;
import com.attornatus.repository.AddressRepository;

@Service
public class AddressService {

    @Autowired
    AddressRepository repository;

    public ResponseEntity<AddressDTO> create(AddressDTO addressDTO) {
        Address address = repository.save(addressDTO.toAddress());
        return ResponseEntity.ok(new AddressDTO(address));
    }

    public ResponseEntity<List<AddressDTO>> read() {

        List<Address> addresss = repository.findAll();
        List<AddressDTO> addresssDTO = new ArrayList<>();

        addresss.forEach((address) -> {
            addresssDTO.add(new AddressDTO(address));
        });

        return ResponseEntity.ok(addresssDTO);
    }

    public ResponseEntity<AddressDTO> getById(Long id) {

        Address address = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address"));

        return ResponseEntity.ok(new AddressDTO(address));
    }

    public ResponseEntity<AddressDTO> update(Long id, AddressDTO addressDTO) {

        Address address = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address"));

        address = repository.save(addressDTO.toAddress());

        return ResponseEntity.ok(new AddressDTO(address));
    }

    public ResponseEntity<Map<String, Boolean>> delete(Long id) {

        Address address = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address"));

        repository.delete(address);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

}
