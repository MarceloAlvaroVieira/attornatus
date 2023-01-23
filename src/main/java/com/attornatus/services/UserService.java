package com.attornatus.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.attornatus.dto.UserDTO;
import com.attornatus.exception.ResourceNotFoundException;
import com.attornatus.model.Address;
import com.attornatus.model.User;
import com.attornatus.repository.AddressRepository;
import com.attornatus.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    AddressRepository addressRepository;

    public ResponseEntity<UserDTO> create(UserDTO userDTO) {

        userDTO.setAddress(findAddress(userDTO.getAddress()));

        User user = repository.save(userDTO.toUser());
        return ResponseEntity.ok(new UserDTO(user));
    }

    public ResponseEntity<List<UserDTO>> read() {

        List<User> users = repository.findAll();
        List<UserDTO> usersDTO = new ArrayList<>();

        System.out.println(users);

        users.forEach((user) -> {
            usersDTO.add(new UserDTO(user));
        });

        return ResponseEntity.ok(usersDTO);
    }

    public ResponseEntity<UserDTO> getById(Long id) {

        User user = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User"));

        return ResponseEntity.ok(new UserDTO(user));
    }

    public ResponseEntity<UserDTO> update(Long id, UserDTO userDTO) {

        User user = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User"));
                
        userDTO.setId(id);
        userDTO.setAddress(findAddress(userDTO.getAddress()));

        user = repository.save(userDTO.toUser());
        return ResponseEntity.ok(new UserDTO(user));
    }

    public ResponseEntity<Map<String, Boolean>> delete(Long id) {

        User user = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User"));

        repository.delete(user);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

    /*
     *Checks the existence of the address in the database and creates it if it does not exist.
     */
    private Address findAddress(Address address){
        Long id = address.getId();
        
        if(id != null)
            address = addressRepository.findById(id).orElse(null);

        if(address == null){
            address = addressRepository.save(address);
        }

        return address;
    }

}
