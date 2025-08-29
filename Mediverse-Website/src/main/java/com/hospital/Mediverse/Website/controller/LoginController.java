package com.hospital.Mediverse.Website.controller;

import com.hospital.Mediverse.Website.model.User;
import com.hospital.Mediverse.Website.model.Role;
import com.hospital.Mediverse.Website.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String showForms(@RequestParam(required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "Invalid email or password");
        }
        return "login";
    }

    @PostMapping("/login-custom")
    public String loginUser(@RequestParam String email,
                            @RequestParam String password,
                            @RequestParam String role,
                            HttpSession session) {
        Role roleEnum = Role.valueOf(role.toUpperCase());
        Optional<User> userOpt = userRepository.findByEmailAndPasswordAndRole(email, password, roleEnum);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            session.setAttribute("user", user);
            return "redirect:/";
        }
        return "redirect:/login?error=true";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}