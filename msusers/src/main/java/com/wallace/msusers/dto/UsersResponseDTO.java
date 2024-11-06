package com.wallace.msusers.dto;

import com.wallace.msusers.domain.entities.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class UsersResponseDTO {

    private String username;
    private String email;
    private Address address;
}
