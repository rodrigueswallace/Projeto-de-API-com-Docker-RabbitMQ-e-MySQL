package com.wallace.msusers.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @NotBlank(message = "The username is required.")
    private String username;

    @NotBlank(message = "The password is required.")
    @Size(min = 6, message = "The password must be at least 6 characters long.")
    private String password;

    @NotBlank(message = "The email is required.")
    @Email(message = "Invalid email.")
    private String email;

    @NotBlank(message = "The ZIP code is required.")
    @Size(min = 8, max = 9, message = "The ZIP code must have 8 characters.")
    private String cep;
}

