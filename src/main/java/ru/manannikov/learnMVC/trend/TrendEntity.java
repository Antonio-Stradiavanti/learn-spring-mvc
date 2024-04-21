package ru.manannikov.learnMVC.trend;

import jakarta.validation.constraints.NotNull;
import ru.manannikov.learnMVC.coin.CoinEntity;

public record TrendEntity(
        @NotNull
        Long id,
        String coinName,
        String coinCode,
        Double twentyFourHourChange
) {
}
