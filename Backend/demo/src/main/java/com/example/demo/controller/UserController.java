package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // ✅ 1. GET USER PROFILE
    @GetMapping("/profile/{username}")
    public User getProfile(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    // ✅ 2. UPDATE USER PROFILE
    @PutMapping("/profile/{username}")
    public User updateProfile(
            @PathVariable String username,
            @RequestBody User updatedUser
    ) {
        User user = userService.findByUsername(username);

        // Update allowed fields only
        user.setUsername(updatedUser.getUsername());
        user.setAvatar(updatedUser.getAvatar());

        return userService.save(user);
    }
}
