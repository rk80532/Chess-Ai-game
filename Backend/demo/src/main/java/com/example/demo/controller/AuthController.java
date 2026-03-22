package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.AuthService;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UserService userService;
    private final AuthService authService;
    private final JwtUtil jwtUtil;

    public AuthController(
            UserService userService,
            AuthService authService,
            JwtUtil jwtUtil
    ) {
        this.userService = userService;
        this.authService = authService;
        this.jwtUtil = jwtUtil;
    }

    // ✅ REGISTER (PUBLIC)
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(
                user.getUsername(),
                user.getEmail(),
                user.getPassword()
        );
    }

    // ✅ LOGIN (RETURNS JWT)
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User user) {

        // 1. Authenticate user (username + password)
        authService.authenticate(user.getUsername(), user.getPassword());

        // 2. Generate JWT token
        String token = jwtUtil.generateToken(user.getUsername());

        // 3. Return token in response
        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        return response;
    }

    // ✅ TEST ENDPOINT (OPTIONAL)
    @GetMapping("/test")
    public String test() {
        return "OK";
    }
}
