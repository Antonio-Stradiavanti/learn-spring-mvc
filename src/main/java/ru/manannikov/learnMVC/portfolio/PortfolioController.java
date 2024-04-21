package ru.manannikov.learnMVC.portfolio;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolios")
public class PortfolioController {
    private final PortfolioRepository repository;
    PortfolioController(PortfolioRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    List<PortfolioEntity> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    PortfolioEntity findById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody PortfolioEntity exchange) {
        repository.create(exchange);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody PortfolioEntity exchange, @PathVariable Long id) {
        repository.update(exchange, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        repository.delete(id);
    }
}
