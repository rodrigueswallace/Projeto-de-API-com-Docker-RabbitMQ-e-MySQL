package com.wallace.msusers.api.controller;

import com.wallace.msusers.api.service.UserService;
import com.wallace.msusers.domain.entities.Users;
import com.wallace.msusers.dto.*;
import com.wallace.msusers.infra.security.TokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;
    private final RabbitTemplate rabbitTemplate;

    @PostMapping("/register")
    public ResponseEntity<UsersResponseDTO> registerUser(@Valid @RequestBody UserDTO userDTO) {

            userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            UsersResponseDTO registeredUser = userService.registerUser(userDTO);
            String routingKey = "orders.v1.order-status";
            MessageDTO messageDTO = new MessageDTO(registeredUser.getUsername());
            messageDTO.setOperation("CREATE");
            rabbitTemplate.convertAndSend(routingKey,messageDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
    }

    @PutMapping("/update-password")
    public ResponseEntity<Void> updatePassword(@Valid @RequestBody UpdatePasswordDTO updatePasswordDTO) {

            userService.updatePassword(updatePasswordDTO);
            String routingKey = "orders.v1.order-status";
            MessageDTO messageDTO = new MessageDTO(updatePasswordDTO.getUsername());
            messageDTO.setOperation("UPDATE");
            rabbitTemplate.convertAndSend(routingKey,messageDTO);
            return ResponseEntity.noContent().build();
    }

    @PostMapping("/auth")
    public ResponseEntity<TokenResponseDTO> getToken(@Valid @RequestBody LoginDTO login) {

            Users user = userService.checkLogin(login);
            String token = tokenService.generateToken(user);
            TokenResponseDTO tokenResponse = new TokenResponseDTO(token);
            return ResponseEntity.ok(tokenResponse);
    }



}
