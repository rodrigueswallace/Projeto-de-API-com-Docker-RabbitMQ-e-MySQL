package com.wallace.msusers.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class MessageDTO {


    private String username;
    private String operation;

    public MessageDTO(String username) {
        this.username = username;
    }
}
