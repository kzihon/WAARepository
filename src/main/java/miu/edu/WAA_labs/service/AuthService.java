package miu.edu.WAA_labs.service;

import miu.edu.WAA_labs.dtos.request.LoginRequest;
import miu.edu.WAA_labs.dtos.request.RefreshTokenRequest;
import miu.edu.WAA_labs.dtos.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
