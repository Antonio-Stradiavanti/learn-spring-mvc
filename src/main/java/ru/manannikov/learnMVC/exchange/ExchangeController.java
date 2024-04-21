package ru.manannikov.learnMVC.exchange;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exchanges")
public class ExchangeController {

    private final ExchangeRepository repository;
    ExchangeController(ExchangeRepository repository) {
        this.repository = repository;
    }
    @GetMapping("")
    List<ExchangeEntity> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    ExchangeEntity findById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody ExchangeEntity exchange) {
        repository.create(exchange);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody ExchangeEntity exchange, @PathVariable Long id) {
        repository.update(exchange, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        repository.delete(id);
    }

}
