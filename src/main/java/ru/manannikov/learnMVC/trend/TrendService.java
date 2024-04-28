package ru.manannikov.learnMVC.trend;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.manannikov.learnMVC.exception.ResourceNotFoundExcetion;
import ru.manannikov.learnMVC.generic.GenericService;

import java.util.List;

@Service
@AllArgsConstructor
public class TrendService implements GenericService<TrendEntity> {

    private final TrendRepository repository;

    @Override
    public TrendEntity create(TrendEntity trend) {
        return repository.save(trend);
    }

    @Override
    public List<TrendEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public TrendEntity findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundExcetion("Тренд с идентификатором id = \"" + id + "\" не найден.\""));
    }

    public void update(TrendEntity trend, Long id) {
        TrendEntity trendEntity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundExcetion("Тренд с идентификатором id = \" + id + \" не найден.\""));
        trendEntity.setId(trend.getId());
        repository.save(trendEntity);
    }

    @Override
    public void delete(Long id) {
        TrendEntity trendEntity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundExcetion("Тренд с идентификатором id = \" + id + \" не найден.\""));
        repository.delete(trendEntity);
    }
}
