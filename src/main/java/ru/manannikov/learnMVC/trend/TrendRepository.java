package ru.manannikov.learnMVC.trend;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.manannikov.learnMVC.coin.CoinEntity;
import ru.manannikov.learnMVC.exception.ResourceNotFoundExcetion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TrendRepository {

    private List<TrendEntity> trends = new ArrayList<>();

    List<TrendEntity> findAll() {
        return trends;
    }

    TrendEntity findById(Long id) {
        return trends.stream().filter(deal -> deal.id().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundExcetion("Тренд с идентификатором id = " + id + " не найден."));
    }

    void create(TrendEntity deal) {
        trends.add(deal);
    }

    void update(TrendEntity trend, Long id) {
        TrendEntity existTrend = findById(id);
        trends.set(trends.indexOf(existTrend), trend);
    }

    void delete(Long id) {
        trends.removeIf(trends -> trends.id().equals(id));
    }

    @PostConstruct
    private void init() {
        trends.add(new TrendEntity(1L, "Bitcoin", "BTC", 23.0
        ));
        trends.add(new TrendEntity(1L, "Ethereum", "ETH", 18.0
        ));
    }
    
}
