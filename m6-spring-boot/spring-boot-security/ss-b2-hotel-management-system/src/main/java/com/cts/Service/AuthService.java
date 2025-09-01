package com.cts.Service;

import com.cts.dto.LoginDTO;
import com.cts.dto.AuthResponseDTO;
import com.cts.dto.RegisterDTO;

public interface AuthService {
    String register(RegisterDTO request);
    AuthResponseDTO login(LoginDTO request);
}
