package ru.manannikov.learnMVC.exchange;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
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
