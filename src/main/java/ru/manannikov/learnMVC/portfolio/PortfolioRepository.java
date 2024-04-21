package ru.manannikov.learnMVC.portfolio;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.manannikov.learnMVC.coin.CoinEntity;
import ru.manannikov.learnMVC.deal.DealEntity;
import ru.manannikov.learnMVC.exception.ResourceNotFoundExcetion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PortfolioRepository {
    private List<PortfolioEntity> portfolios = new ArrayList<>();

    List<PortfolioEntity> findAll() {
        return portfolios;
    }

    PortfolioEntity findById(Long id) {
        return portfolios.stream().filter(exchange -> exchange.id().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundExcetion("Портфолио с идентификатором id = " + id + " не найдено."));
    }

    void create(PortfolioEntity exchange) {
        portfolios.add(exchange);
    }

    void update(PortfolioEntity exchange, Long id) {
        PortfolioEntity existCoin = findById(id);
        portfolios.set(portfolios.indexOf(existCoin), exchange);
    }

    void delete(Long id) {
        portfolios.removeIf(portfolio -> portfolio.id().equals(id));
    }

    @PostConstruct
    private void init() {
       portfolios.add(new PortfolioEntity(
            1L, List.of(new CoinEntity(1L, "Bitcoin", "BTC", 50000.0, -25.0, 23.0, 56.0, 2303534050432.0, 4395723867.0, List.of(324.0, 436.0, 584.0, 987.0, 674.0))),
               List.of(new DealEntity(1L, LocalDateTime.of(2024, 2, 2, 12, 33, 33), "sell", 3543256.0, 3.0, "Bitcoin", "BTC"
               )), List.of(324.0,436.0,584.0,987.0,674.0), List.of(324.0,436.0,584.0,987.0,674.0), 345.0, 345.0
       ));
    }
}
