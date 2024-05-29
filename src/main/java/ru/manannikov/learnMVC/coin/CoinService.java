package ru.manannikov.learnMVC.coin;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.manannikov.learnMVC.exception.ResourceNotFoundExcetion;
import ru.manannikov.learnMVC.generic.GenericService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CoinService implements GenericService<CoinEntity> {

    private final CoinRepository repository;

    @Override
    public CoinEntity create(CoinEntity coin) {
        return repository.save(coin);
    }

    @Override
    public List<CoinEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public CoinEntity findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundExcetion("Коин с идентификатором id = \"" + id + "\" не найден.\""));
    }

    public void update(CoinEntity coin, Long id) {
        CoinEntity coinEntity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundExcetion("Коин с идентификатором id = \" + id + \" не найден.\""));
        coinEntity.setId(coin.getId());
        repository.save(coinEntity);
    }

    @Override
    public void delete(Long id) {
        CoinEntity coinEntity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundExcetion("Коин с идентификатором id = \" + id + \" не найден.\""));
        repository.delete(coinEntity);
    }

    @Transactional
    public void saveOrUpdateCoins(List<CoinEntity> coins) {
        for (CoinEntity coin : coins) {
            Optional<CoinEntity> exitingCoinOptional = repository.findByCoinCode(coin.getCoinCode());
            if (exitingCoinOptional.isPresent()) {
                CoinEntity existingCoin = exitingCoinOptional.get();

                existingCoin.setCoinName(coin.getCoinName());
                existingCoin.setCoinCode(coin.getCoinCode());
                existingCoin.setPrice(coin.getPrice());

                existingCoin.setOneHourChange(coin.getOneHourChange());
                existingCoin.setTwentyFourHourChange(coin.getTwentyFourHourChange());
                existingCoin.setSevenDayChange(coin.getSevenDayChange());

                existingCoin.setMarketCap(coin.getMarketCap());
                existingCoin.setVolume(coin.getVolume());

                repository.save(existingCoin);
            } else {
                repository.save(coin);
            }
        }
    }
}
