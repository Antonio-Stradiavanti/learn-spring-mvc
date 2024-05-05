package ru.manannikov.learnMVC.deal;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.manannikov.learnMVC.coin.CoinEntity;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="deals", schema="public")
public class DealEntity {
        @Id @GeneratedValue
        private Long id;

        private LocalDateTime date;

        @Column(nullable=false)
        private String type;

        private Double price;

        private Double volume;

        // Одна и та же монета может участвовать во многих сделках
        // У нас владельцем отношения является не коин, а сделка.
        @ManyToOne
        @JoinColumn(name = "coin_id", nullable = false)
        @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
        @JsonIdentityReference(alwaysAsId = true)
        private CoinEntity coin;

}
