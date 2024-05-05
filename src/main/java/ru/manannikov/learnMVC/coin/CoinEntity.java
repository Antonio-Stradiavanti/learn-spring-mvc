package ru.manannikov.learnMVC.coin;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.manannikov.learnMVC.deal.DealEntity;
import ru.manannikov.learnMVC.portfolio.PortfolioEntity;
import ru.manannikov.learnMVC.trend.TrendEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="coins", schema="public")
public class CoinEntity  {
    @Id @GeneratedValue
    private Long id;

    @Column(name="coin_name", nullable = false, unique = true)
    private String coinName;

    @Column(name="coin_code", nullable = false, unique = true)
    private String coinCode;

    @Column(precision=6, nullable = false)
    private Double price;

    @Column(name="1h")
    private Double oneHourChange;

    @Column(name="12h")
    private Double twentyFourHourChange;

    @Column(name="7d")
    private Double sevenDayChange;

    @Column(name="market_cap", nullable = false)
    private Double marketCap;

    @Column(nullable = false)
    private Double volume;

    @ElementCollection
    @Column(name="last_price")
    private List<Double> lastPrice;

    // Указываем имя свойства (пр. столбец таблицы), которое соответствует отношению на стороне владельца
    @ManyToMany(mappedBy = "coins")
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId = true)
    private Set<PortfolioEntity> portfolios;

    @OneToMany(mappedBy="coin")
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId = true)
    private Set<DealEntity> deals;

    @OneToMany(mappedBy="coin")
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId = true)
    private Set<TrendEntity> trends;

}
