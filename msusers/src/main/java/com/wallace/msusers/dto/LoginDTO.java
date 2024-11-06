package com.wallace.msusers.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {

    @NotBlank(message = "The username is required.")
    private String username;

    @NotBlank(message = "The password is required.")
    @Size(min = 6, message = "The password must be at least 6 characters long.")
    private String password;
}
