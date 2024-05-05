package ru.manannikov.learnMVC.exchange;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exchanges")
@AllArgsConstructor
public class ExchangeController {

    private final ExchangeService service;

    @GetMapping("")
    List<ExchangeEntity> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    ExchangeEntity findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@RequestBody ExchangeEntity exchange) {
        service.create(exchange);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@RequestBody ExchangeEntity exchange, @PathVariable Long id) {
        service.update(exchange, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
