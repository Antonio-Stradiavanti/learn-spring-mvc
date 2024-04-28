package ru.manannikov.learnMVC.portfolio;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.manannikov.learnMVC.exception.ResourceNotFoundExcetion;
import ru.manannikov.learnMVC.generic.GenericService;

import java.util.List;

@Service
@AllArgsConstructor
public class PortfolioService implements GenericService<PortfolioEntity> {

    private final PortfolioRepository repository;
    
    @Override
    public PortfolioEntity create(PortfolioEntity portfolio) {
        return repository.save(portfolio);
    }

    @Override
    public List<PortfolioEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public PortfolioEntity findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundExcetion("Портфолио с идентификатором id = \"" + id + "\" не найдено.\""));
    }

    public void update(PortfolioEntity portfolio, Long id) {
        PortfolioEntity portfolioEntity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundExcetion("Коин с идентификатором id = \" + id + \" не найден.\""));
        portfolioEntity.setId(portfolio.getId());
        repository.save(portfolioEntity);
    }
    
    @Override
    public void delete(Long id) {

    }
}
