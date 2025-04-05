package com.p1.EmpManagement.Controller;

import com.p1.EmpManagement.Entity.User;
import com.p1.EmpManagement.Entity.Role;
import com.p1.EmpManagement.Repo.User_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final User_Repo userRepo;
    private final PasswordEncoder encoder;

    @Autowired
    public AuthController(User_Repo userRepo, PasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.encoder = encoder;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword())); // encode the password
        user.setRole(Role.ROLE_EMPLOYEE); // set default role or get from request
        userRepo.save(user);
        return "User registered successfully!";
    }
}
