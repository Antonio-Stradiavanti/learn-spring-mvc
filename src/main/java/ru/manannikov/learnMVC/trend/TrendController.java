package ru.manannikov.learnMVC.trend;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trends")
public class TrendController {
    private final TrendRepository repository;

    TrendController(TrendRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    List<TrendEntity> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    TrendEntity findById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody TrendEntity trend) {
        repository.create(trend);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody TrendEntity trend, @PathVariable Long id) {
        repository.update(trend, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        repository.delete(id);
    }
}
