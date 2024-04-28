package ru.manannikov.learnMVC.coin;

import jakarta.annotation.PostConstruct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.manannikov.learnMVC.exception.ResourceNotFoundExcetion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface CoinRepository extends JpaRepository<CoinEntity, Long> {

}
