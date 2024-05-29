package ru.manannikov.learnMVC.scheduling;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ScheduleTaskStatusEntity {
    @Id @GeneratedValue
    Long id;
    LocalDateTime updateDateTime;
    boolean isSuccess;

}
