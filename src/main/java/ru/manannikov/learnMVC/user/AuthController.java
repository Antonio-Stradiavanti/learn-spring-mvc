package ru.manannikov.learnMVC.user;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    @PostMapping("/register")
    public UserEntity registerUser(@RequestBody UserEntity userEntity) {
       userEntity.setPassword(encoder.encode(userEntity.getPassword()));
       return repository.save(userEntity);
    }


}