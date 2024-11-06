package com.wallace.msusers.dto.mapper;

import com.wallace.msusers.domain.entities.Address;
import com.wallace.msusers.dto.AddressDTO;

public class AddressMapper {

    public static Address toAddress(AddressDTO addressCep){
        Address address = new Address();
        address.setZipCode(addressCep.getZipCode());
        address.setStreet(addressCep.getStreet());
        address.setComplement(addressCep.getComplement());
        address.setNeighborhood(addressCep.getNeighborhood());
        address.setCity(addressCep.getCity());
        address.setState(addressCep.getState());

        return address;
    }

}
