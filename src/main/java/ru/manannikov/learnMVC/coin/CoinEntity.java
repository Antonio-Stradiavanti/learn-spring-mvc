package ru.manannikov.learnMVC.coin;

import java.util.List;
import jakarta.validation.constraints.*;

public record CoinEntity(
    @NotNull
    Long id,
    @NotEmpty
    String coinName,
    @NotEmpty
    String coinCode,
    Double price,
    Double oneHourChange,
    Double twentyFourHourChange,
    Double sevenDayChange,
    Double marketCap,
    Double volume,
    List<Double> lastPrice
)  {
}
