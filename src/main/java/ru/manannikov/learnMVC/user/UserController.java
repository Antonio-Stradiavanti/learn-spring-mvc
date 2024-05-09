package ru.manannikov.learnMVC.user;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/admin/users")
@AllArgsConstructor
@Hidden
public class UserController {
    private final UserService service;

    @GetMapping("")
    public List<UserAccountEntity> findAll() {
        return service.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody UserAccountEntity coin) {
        service.create(coin);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}