package com.hospital.Mediverse.Website.controller;

import com.hospital.Mediverse.Website.model.Role;
import com.hospital.Mediverse.Website.model.User;
import com.hospital.Mediverse.Website.model.RegisterRequest;
import com.hospital.Mediverse.Website.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.HashMap;
import java.util.Map;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterRequest registerRequest) {
        Optional<User> existingUser = userRepository.findByEmail(registerRequest.getEmail());
        if (existingUser.isPresent()) {
            return new ResponseEntity<>("Email is already registered!", HttpStatus.CONFLICT);
        }

        Role role;
        if (registerRequest.getRole() == null || registerRequest.getRole().isBlank()) {
            role = Role.PATIENT;
        } else {
            role = Role.valueOf(registerRequest.getRole().toUpperCase());
        }

        User user = new User(
                registerRequest.getFirstName(),
                registerRequest.getLastName(),
                registerRequest.getEmail(),
                registerRequest.getPassword(),
                role
        );

        userRepository.save(user);
        return new ResponseEntity<>("User registered successfully! You can now log in.", HttpStatus.CREATED);
    }

    @GetMapping("/session")
    public Map<String, Object> getSessionInfo(HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        Object userObj = session.getAttribute("user");
        if (userObj instanceof User) {
            User user = (User) userObj;
            response.put("loggedIn", true);
            response.put("firstName", user.getFirstName());
            response.put("lastName", user.getLastName());
            response.put("email", user.getEmail());
            response.put("role", user.getRole());
        } else {
            response.put("loggedIn", false);
        }
        return response;
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> apiLogout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok().build();
    }
}