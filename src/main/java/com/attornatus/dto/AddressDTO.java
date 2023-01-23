package com.attornatus.dto;

import com.attornatus.model.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private long id;
    private String street;
    private String zipCode;
    private int number;
    private String city;

    public AddressDTO(Address address){
        this.id = address.getId();
        this.street = address.getStreet();
        this.zipCode = address.getZipCode();
        this.number = address.getNumber();
        this.city = address.getCity();
    }

    public Address toAddress(){
        return new Address(
            this.getId(),
            this.getStreet(),
            this.getZipCode(),
            this.getNumber(),
            this.getCity()
        );
    }
}
