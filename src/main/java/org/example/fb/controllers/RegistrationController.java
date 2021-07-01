package org.example.fb.controllers;

import org.example.fb.model.AuthUser;
import org.example.fb.service.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String registrationPage() {
        return "register";
    }

    @PostMapping
    public String registerUser(@RequestParam("username") String username,
                               @RequestParam("password") String password) {
        AuthUser authUser = userService.register(username, password);
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(authUser, password));
        return "redirect:/";
    }

}
