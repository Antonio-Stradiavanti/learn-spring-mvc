package ru.manannikov.learnMVC.coin;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.manannikov.learnMVC.generic.GenericController;

import java.util.List;

@RestController
@RequestMapping("/api/coins")
@AllArgsConstructor
public class CoinController implements GenericController<CoinEntity> {

    private final CoinService service;

    @Override
    @GetMapping("")
    public List<CoinEntity> findAll() {
        return service.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public CoinEntity findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody CoinEntity coin) {
        service.create(coin);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody CoinEntity coin, @PathVariable Long id) {
        service.update(coin, id);
    }

    @Override
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
