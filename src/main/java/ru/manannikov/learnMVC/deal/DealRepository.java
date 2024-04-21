package ru.manannikov.learnMVC.deal;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.manannikov.learnMVC.coin.CoinEntity;
import ru.manannikov.learnMVC.exception.ResourceNotFoundExcetion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DealRepository {
    private List<DealEntity> deals = new ArrayList<>();

    List<DealEntity> findAll() {
        return deals;
    }

    DealEntity findById(Long id) {
        return deals.stream().filter(deal -> deal.id().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundExcetion("Сделка с идентификатором id = " + id + " не найдена."));
    }

    void create(DealEntity deal) {
        deals.add(deal);
    }

    void delete(Long id) {
        deals.removeIf(deals -> deals.id().equals(id));
    }

    @PostConstruct
    private void init() {
       deals.add(new DealEntity(1L, LocalDateTime.of(2024, 2, 2, 12, 33, 33), "sell", 3543256.0, 3.0, "Bitcoin", "BTC"
       ));
       deals.add(new DealEntity(111L, LocalDateTime.of(2024, 4, 21, 15, 0, 0), "sell", 72334.31, 23.0, "Ethereum", "ETH"
       ));
    }

}
