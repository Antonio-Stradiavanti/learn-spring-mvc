package ru.manannikov.learnMVC.portfolio;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.manannikov.learnMVC.generic.GenericController;

import java.util.List;

@RestController
@RequestMapping("/api/portfolios")
@AllArgsConstructor
@Tag(
        name = "Запросы к таблице базы данных \"portfolios\"",
        description = "HTTP запросы типов POST, PUT, DELETE -> доступны только авторизированным пользователям."
)
public class PortfolioController implements GenericController<PortfolioEntity> {
    private final PortfolioService service;

    @Override
    @GetMapping("")
    public List<PortfolioEntity> findAll() {
        return service.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public PortfolioEntity findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody PortfolioEntity coin) {
        service.create(coin);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody PortfolioEntity coin, @PathVariable Long id) {
        service.update(coin, id);
    }

    @Override
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
