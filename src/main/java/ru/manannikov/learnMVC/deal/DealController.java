package ru.manannikov.learnMVC.deal;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.manannikov.learnMVC.generic.GenericController;

import java.util.List;

@RestController
@RequestMapping("/api/deals")
@AllArgsConstructor
@Tag(
        name = "Запросы к таблице базы данных \"deals\"",
        description = "HTTP запросы типов POST, PUT, DELETE -> доступны только авторизированным пользователям."
)
public class DealController implements GenericController<DealEntity> {
    
    private final DealSerivce service;


    @GetMapping("")
    @Override
    public List<DealEntity> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @Override
    public DealEntity findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    @Override
    public void create(@RequestBody DealEntity deal) {
        service.create(deal);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    @Override
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
