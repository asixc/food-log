package dev.jotxee.food_log.repository;


import dev.jotxee.food_log.entity.MealLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Collection;

public interface MealLogRepository extends JpaRepository<MealLog, String> {
    Collection<MealLog> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
