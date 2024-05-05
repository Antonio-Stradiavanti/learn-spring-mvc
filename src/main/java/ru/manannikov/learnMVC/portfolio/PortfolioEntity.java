package ru.manannikov.learnMVC.portfolio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.manannikov.learnMVC.coin.CoinEntity;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="portfolios", schema="public")
public class PortfolioEntity{
    @Id @GeneratedValue
    private Long id;

    @ManyToMany
    // Указываем название таблицы связей на стороне владельца и ее внешние ключи
    @JoinTable(
            name="portfolio_coin",
            joinColumns = @JoinColumn(name="portfolio_id"),
            inverseJoinColumns = @JoinColumn(name="coin_id")
    )
    private Set<CoinEntity> coins;

    @ElementCollection
    @Column(name="profile_volume_usd")
    private List<Double> profileVolumeUsd;

    @ElementCollection
    @Column(name="profile_volume_btc")
    private List<Double> profileVolumeBtc;

    @Column(name="current_volume_usd")
    private Double currentVolumeUsd;

    @Column(name="current_volume_btc")
    private Double currentVolumeBtc;


}
