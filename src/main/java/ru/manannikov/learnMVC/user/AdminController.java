package ru.manannikov.learnMVC.user;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/users")
// Для запросов между различными источниками
@CrossOrigin("*")
@Hidden
public class AdminController {

    // Нужно только для тестирования привелегий пользователей
    @GetMapping()
    public String helloAdminController() {
        return "Доступно админу";
    }


//    private final UserService service;
//    private final PasswordEncoder encoder;
//
//    public UserController(UserService service, PasswordEncoder encoder) {
//        this.service = service;
//        this.encoder = encoder;
//    }
//
//    @GetMapping("")
//    public List<UserEntity> findAll() {
//        return service.findAll();
//    }
//
//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping("")
//    public void create(@RequestBody UserEntity coin) {
//        coin.setPassword(encoder.encode(coin.getPassword()));
//        service.create(coin);
//    }
//
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id) {
//        service.delete(id);
//    }

}