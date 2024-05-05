package ru.manannikov.learnMVC.exchange;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="exchanges", schema="public")
public class ExchangeEntity {
    @Id @GeneratedValue
    Long id;

    @Column(nullable = false, unique = true)
    String name;

    Double score;

    @Column(name = "volume_24h")
    Double volume24h;

    Double markets;

    Double coins;

    @ElementCollection
    @Column(name = "last_volume")
    List<Double> lastVolume;

}
