package net.yc.race.track.controller;

import lombok.RequiredArgsConstructor;
import net.yc.race.track.model.User;
import net.yc.race.track.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser() {
         return ResponseEntity.ok("Login successful");
    }
}
