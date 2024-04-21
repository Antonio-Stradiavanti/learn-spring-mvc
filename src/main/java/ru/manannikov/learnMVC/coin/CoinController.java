package ru.manannikov.learnMVC.coin;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coins")
public class CoinController {

    private final CoinRepository repository;
    CoinController(CoinRepository repository) {
       this.repository = repository;
    }
    @GetMapping("")
    List<CoinEntity> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    CoinEntity findById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody CoinEntity coin) {
        repository.create(coin);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody CoinEntity coin, @PathVariable Long id) {
        repository.update(coin, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        repository.delete(id);
    }
}
