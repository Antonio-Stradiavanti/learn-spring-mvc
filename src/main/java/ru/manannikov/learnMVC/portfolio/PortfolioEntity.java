package ru.manannikov.learnMVC.portfolio;

import ru.manannikov.learnMVC.coin.CoinEntity;
import ru.manannikov.learnMVC.deal.DealEntity;

import java.util.List;

public record PortfolioEntity(
        Long id,
        List<CoinEntity> coins,
        List<DealEntity> deals,
        List<Double> profileVolumeUsd,
        List<Double> profileVolumeBtc,
        Double currentVolumeUsd,
        Double currentVolumeBtc

) {
}
