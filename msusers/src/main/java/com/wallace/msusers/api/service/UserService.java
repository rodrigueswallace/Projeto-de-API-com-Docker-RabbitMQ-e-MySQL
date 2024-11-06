package com.wallace.msusers.api.service;

import com.wallace.msusers.api.repository.AddressRepository;
import com.wallace.msusers.api.repository.UserRepository;
import com.wallace.msusers.dto.LoginDTO;
import com.wallace.msusers.dto.UpdatePasswordDTO;
import com.wallace.msusers.dto.UserDTO;
import com.wallace.msusers.dto.UsersResponseDTO;
import com.wallace.msusers.dto.mapper.AddressMapper;
import com.wallace.msusers.dto.mapper.UsersMapper;
import com.wallace.msusers.domain.entities.Address;
import com.wallace.msusers.domain.entities.Users;
import com.wallace.msusers.exception.CustomExceptions.InvalidPasswordException;
import com.wallace.msusers.exception.CustomExceptions.UserAlreadyExistsException;
import com.wallace.msusers.exception.CustomExceptions.UserNotFoundException;
import com.wallace.msusers.infra.ViaCepClient;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final ViaCepClient viaCepClient;
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UsersResponseDTO registerUser(UserDTO userDTO) {

        if (userRepository.existsByEmail(userDTO.getEmail()) || userRepository.existsByUsername(userDTO.getUsername())) {
            throw new UserAlreadyExistsException("User already exists");
        }
        Users users = new Users(userDTO.getUsername(), userDTO.getPassword(), userDTO.getEmail());
        Address address = addressRepository.save(AddressMapper.toAddress(viaCepClient.getAddressByCep(userDTO.getCep())));
        users.setAddress(address);
        userRepository.save(users);
        return UsersMapper.toUserResponseDTO(users);
    }

    @Transactional
    public void updatePassword(UpdatePasswordDTO updatePasswordDTO) {
        Users user = userRepository.findByUsername(updatePasswordDTO.getUsername())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        if (!passwordEncoder.matches(updatePasswordDTO.getOldPassword(), user.getPassword())) {
            throw new InvalidPasswordException("Old password is not correct");
        }

        user.setPassword(passwordEncoder.encode(updatePasswordDTO.getNewPassword()));
        userRepository.save(user);
    }

    @Transactional
    public Users checkLogin(LoginDTO loginDTO) {
        Users user = userRepository.findByUsername(loginDTO.getUsername())
                .orElseThrow(() -> new UserNotFoundException("Invalid username or password"));

        if (!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            throw new InvalidPasswordException("Invalid username or password");
        }
        return user;
    }
}
