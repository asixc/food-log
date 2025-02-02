package dev.jotxee.food_log.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record MealLogRequest(
        String email,
        String mealType,
        LocalDate date,
        LocalTime time,
        String foodItems,
        Double calories,
        String photoUrl,
        String notes,
        String location,
        String mood,
        String dietType,
        Integer diners,
        String companions
) {}
