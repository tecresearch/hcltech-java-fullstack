package com.cts.Service.impl;

import com.cts.Entity.MyUser;

import com.cts.Repository.UserRepository;
import com.cts.Service.AuthService;
import com.cts.dto.LoginDTO;
import com.cts.dto.AuthResponseDTO;
import com.cts.dto.RegisterDTO;
import com.cts.security.JwtService;
import com.cts.security.UserPrincipal;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public String register(RegisterDTO request) {

    	if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists: " + request.getEmail());
        }

        if ("ADMIN".equalsIgnoreCase(request.getRole())) {
            throw new RuntimeException("Cannot register as ADMIN");
        }

        MyUser user = new MyUser();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setContactNumber(request.getContactNumber());

        try {
            user.setRole(MyUser.Role.valueOf(request.getRole().toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid role: " + request.getRole());
        }

        userRepository.save(user);
        return "Registration successful";
    }

    @Override
    public AuthResponseDTO login(LoginDTO request) {

    	authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getEmail(), request.getPassword()
            )
        );

        MyUser user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtService.generateToken(new UserPrincipal(user));

        return new AuthResponseDTO(token);
    }
}
