package com.attornatus.dto;

import java.sql.Date;

import com.attornatus.model.Address;
import com.attornatus.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private long id;
    private String name;
    private Date birthDate;
    private Address address;

    public UserDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.birthDate = user.getBirthDate();
        this.address = user.getAddress();
    }

    public User toUser(){
        return new User(
            this.getId(),
            this.getName(),
            this.getBirthDate(),
            this.getAddress()
        );
    }
}
