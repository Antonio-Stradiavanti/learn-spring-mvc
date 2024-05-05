package ru.manannikov.learnMVC.deal;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.manannikov.learnMVC.exception.ResourceNotFoundExcetion;
import ru.manannikov.learnMVC.generic.GenericService;

import java.util.List;

@Service
@AllArgsConstructor
public class DealSerivce implements GenericService<DealEntity> {

    private final DealRepository repository;

    @Override
    public DealEntity create(DealEntity dealEntity) {
        return repository.save(dealEntity);
    }

    @Override
    public List<DealEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public DealEntity findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundExcetion("Сделка с идентификатором id = \"" + id + "\" не найдена.\""));
    }

    @Override
    public void delete(Long id) {
        DealEntity dealEntity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundExcetion("Сделка с идентификатором id = \"" + id + "\" не найдена.\""));
        repository.delete(dealEntity);
    }
}
