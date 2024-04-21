package ru.manannikov.learnMVC.deal;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DealEntity(
        @NotNull
        Long id,
        LocalDateTime date,
        @NotEmpty
        String type,
        Double price,
        Double volume,
        @NotEmpty
        String coinName,
        @NotNull
        String coinCode
) {
}
