package ru.manannikov.learnMVC.trend;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trends")
@AllArgsConstructor
@Tag(
        name = "Запросы к таблице базы данных \"trends\"",
        description = "HTTP запросы типов POST, PUT, DELETE -> доступны только авторизированным пользователям."
)
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
