package ru.manannikov.learnMVC.scheduling;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleTaskStatusRepository extends JpaRepository<ScheduleTaskStatusEntity, Long> {
}
