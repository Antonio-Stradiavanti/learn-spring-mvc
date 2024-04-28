package ru.manannikov.learnMVC.trend;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trends")
@AllArgsConstructor
public class TrendController {
    private final TrendService service;

    @GetMapping("")
    List<TrendEntity> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    TrendEntity findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody TrendEntity trend) {
        service.create(trend);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody TrendEntity trend, @PathVariable Long id) {
        service.update(trend, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
