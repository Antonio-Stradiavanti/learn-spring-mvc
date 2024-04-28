package ru.manannikov.learnMVC.trend;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TrendRepository extends JpaRepository<TrendEntity, Long> {}
