package dev.jotxee.food_log.repository;


import dev.jotxee.food_log.entity.MealLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealLogRepository extends JpaRepository<MealLog, String> {
}
