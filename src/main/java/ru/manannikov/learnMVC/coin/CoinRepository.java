package ru.manannikov.learnMVC.coin;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.manannikov.learnMVC.exception.ResourceNotFoundExcetion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CoinRepository {
    private List<CoinEntity> coins = new ArrayList<>();
    // По умолчанию член класса является открытым в своём пакете.
    List<CoinEntity> findAll() {
        return coins;
    }

    CoinEntity findById(Long id) {
        return coins.stream().filter(coin -> coin.id().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundExcetion("Коин с идентификатором id = " + id + " не найден."));
    }

    void create(CoinEntity coin) {
        coins.add(coin);
    }

    void update(CoinEntity coin, Long id) {
        CoinEntity existCoin = findById(id);
        coins.set(coins.indexOf(existCoin), coin);
    }

    void delete(Long id) {
        coins.removeIf(coin -> coin.id().equals(id));
    }

    @PostConstruct
    private void init() {
        coins.add(new CoinEntity(1L, "Bitcoin", "BTC", 50000.0, -25.0, 23.0, 56.0, 2303534050432.0, 4395723867.0, List.of(324.0, 436.0, 584.0, 987.0, 674.0)
        ));
        coins.add(new CoinEntity(2L, "Ethereum", "ETH", 3149.06, -10.5, -10.74, 103.0, 378111855.677, 9957574.277, List.of(3124.0, 3148.90, 3248.18, 3062.5, 2973.58)
        ));
    }
}
