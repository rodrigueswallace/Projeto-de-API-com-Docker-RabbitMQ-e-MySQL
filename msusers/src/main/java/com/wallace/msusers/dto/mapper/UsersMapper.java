package com.wallace.msusers.dto.mapper;

import com.wallace.msusers.dto.UsersResponseDTO;
import com.wallace.msusers.domain.entities.Users;

public class UsersMapper {

    public static UsersResponseDTO toUserResponseDTO(Users users){

        return new UsersResponseDTO(users.getUsername(), users.getEmail(), users.getAddress());
    }
}
