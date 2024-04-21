package ru.manannikov.learnMVC.exchange;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ExchangeEntity(
    @NotNull
    Long id,
    @NotEmpty
    String name,
    Double score,
    Double volume24h,
    Double markets,
    Double coins,
    List<Double> lastVolume
) {
}
