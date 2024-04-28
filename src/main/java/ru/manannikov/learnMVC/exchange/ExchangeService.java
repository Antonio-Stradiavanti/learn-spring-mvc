package ru.manannikov.learnMVC.exchange;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.manannikov.learnMVC.exception.ResourceNotFoundExcetion;
import ru.manannikov.learnMVC.generic.GenericService;

import java.util.List;

@Service
@AllArgsConstructor
public class ExchangeService implements GenericService<ExchangeEntity> {
    
    private final ExchangeRepository repository;
    
    @Override
    public ExchangeEntity create(ExchangeEntity exchangeEntity) {
        return repository.save(exchangeEntity);
    }

    @Override
    public List<ExchangeEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public ExchangeEntity findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundExcetion("Биржа с идентификатором id = \"" + id + "\" не найдена.\""));
    }

    public void update(ExchangeEntity exchange, Long id) {
        ExchangeEntity exchangeEntity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundExcetion("Биржа с идентификатором id = \"" + id + "\" не найдена.\""));
        exchangeEntity.setId(exchangeEntity.getId());
        repository.save(exchangeEntity);
    }
    
    @Override
    public void delete(Long id) {
        ExchangeEntity exchangeEntity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundExcetion("Биржа с идентификатором id = \"" + id + "\" не найдена.\""));
        repository.delete(exchangeEntity);
    }
}
