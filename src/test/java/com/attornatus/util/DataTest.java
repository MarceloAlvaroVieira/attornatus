package com.attornatus.util;

import java.sql.Date;

import com.attornatus.dto.AddressDTO;
import com.attornatus.dto.UserDTO;
import com.attornatus.model.Address;
import com.attornatus.model.User;

public class DataTest {
   
    static Address address = new Address(null, "Centro", "35555000", 317, "Camacho");
    static User user = new User(1L, "Marcelo", Date.valueOf("2003-03-13"), address);
   
    public static UserDTO createUser(){
        return new UserDTO(user);
    }   

    public static UserDTO updateUser(){
        UserDTO userDTO = new UserDTO(user);
        userDTO.setId(1L);
        userDTO.setName("Marcelo Álvaro");
        return userDTO;
    } 

    public static AddressDTO createAddress(){
        address.setId(1L);
        return new AddressDTO(address);
    }   

    public static AddressDTO updateAddress(){
        AddressDTO addressDTO = new AddressDTO(address);
        addressDTO.setId(1L);
        addressDTO.setStreet("Street");
        return addressDTO;
    } 
}
