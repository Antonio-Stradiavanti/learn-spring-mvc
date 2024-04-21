package ru.manannikov.learnMVC.exchange;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.manannikov.learnMVC.exception.ResourceNotFoundExcetion;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ExchangeRepository {
    private List<ExchangeEntity> exchanges = new ArrayList<>();
    // По умолчанию член класса является открытым в своём пакете.
    List<ExchangeEntity> findAll() {
        return exchanges;
    }

    ExchangeEntity findById(Long id) {
        return exchanges.stream().filter(exchange -> exchange.id().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundExcetion("Биржа с идентификатором id = " + id + " не найдена."));
    }

    void create(ExchangeEntity exchange) {
        exchanges.add(exchange);
    }

    void update(ExchangeEntity exchange, Long id) {
        ExchangeEntity existCoin = findById(id);
        exchanges.set(exchanges.indexOf(existCoin), exchange);
    }

    void delete(Long id) {
        exchanges.removeIf(exchange -> exchange.id().equals(id));
    }

    @PostConstruct
    private void init() {
        exchanges.add(new ExchangeEntity(1L, "Binance", 9.0, 364578658725.0, 67.0, 45.0, List.of(324.0, 436.0, 584.0, 987.0, 674.0)
        ));
        exchanges.add(new ExchangeEntity(2L, "OKX", 8.0, 1994075460.27, 67.0, 45.0, List.of(324.0, 436.0, 584.0, 987.0, 674.0)
        ));
    }
}
