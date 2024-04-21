package ru.manannikov.learnMVC.deal;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.manannikov.learnMVC.coin.CoinEntity;

import java.util.List;

@RestController
@RequestMapping("/api/deals")
public class DealController {
    private final DealRepository repository;

    public DealController(DealRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    List<DealEntity> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    DealEntity findById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody DealEntity deal) {
        repository.create(deal);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        repository.delete(id);
    }

}
