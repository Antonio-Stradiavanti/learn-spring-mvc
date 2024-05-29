package ru.manannikov.learnMVC.coin;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoinRepository extends JpaRepository<CoinEntity, Long> {
    Optional<CoinEntity> findByCoinCode(String coinCode);
}
