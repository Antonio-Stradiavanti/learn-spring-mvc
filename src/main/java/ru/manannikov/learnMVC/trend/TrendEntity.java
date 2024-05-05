package ru.manannikov.learnMVC.trend;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.manannikov.learnMVC.coin.CoinEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="trends", schema="public")
public class TrendEntity {
        @Id @GeneratedValue
        private Long id;

        @ManyToOne
        @JoinColumn(name = "coin_id")
        private CoinEntity coin;

        @Column(name = "24h")
        private Double twentyFourHourChange;
}
