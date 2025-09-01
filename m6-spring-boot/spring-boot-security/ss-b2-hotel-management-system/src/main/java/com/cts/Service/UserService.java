package com.cts.Service;

import com.cts.dto.UserDTO;
import com.cts.dto.RegisterDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    List<UserDTO> findAll();
    UserDTO getUserById(Long id);
    ResponseEntity<UserDTO> updateUser(UserDTO userDto);
    String deleteUser(Long id);
    String registerUser(RegisterDTO request);
}