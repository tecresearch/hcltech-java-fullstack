package com.cts.Service.impl;

import com.cts.Entity.MyUser;
import com.cts.Repository.UserRepository;
import com.cts.Service.UserService;
import com.cts.dto.UserDTO;
import com.cts.dto.RegisterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private UserDTO entityToDTO(MyUser user) {
        return UserDTO.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .email(user.getEmail())
                .contactNumber(user.getContactNumber())
                .role(user.getRole().name())
                .build();
    }

    private MyUser dtoToEntity(UserDTO dto) {
        return MyUser.builder()
                .userId(dto.getUserId())
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .contactNumber(dto.getContactNumber())
                .role(MyUser.Role.valueOf(dto.getRole()))
                .build();
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
        MyUser user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
        return entityToDTO(user);
    }

    @Override
    public ResponseEntity<UserDTO> updateUser(UserDTO userDto) {
        MyUser existingUser = userRepository.findById(userDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userDto.getUserId()));
        existingUser.setName(userDto.getName());
        existingUser.setEmail(userDto.getEmail());
        existingUser.setContactNumber(userDto.getContactNumber());
        existingUser.setRole(MyUser.Role.valueOf(userDto.getRole()));
        return ResponseEntity.ok(entityToDTO(userRepository.save(existingUser)));
    }

    @Override
    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "User deleted successfully!";
    }

    @Override
    public String registerUser(RegisterDTO request) {
    	
    	if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists: " + request.getEmail());
        }
        MyUser user = MyUser.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .contactNumber(request.getContactNumber())
                .role(MyUser.Role.valueOf(request.getRole().toUpperCase()))
                .build();
        userRepository.save(user);
        return "User registered successfully";
    }
}

