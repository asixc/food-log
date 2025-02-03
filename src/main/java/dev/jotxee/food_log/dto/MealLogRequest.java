package dev.jotxee.food_log.dto;

import dev.jotxee.food_log.enums.MoodEnum;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record MealLogRequest(
        Long id,
        String email,
        @NotNull String mealType,
        @NotNull LocalDate date,
        @NotNull LocalTime time,
        @NotNull String foodItems,
        Double calories,
        String photoUrl,
        String notes,
        String location,
        @NotNull MoodEnum mood,
        String dietType,
        Integer diners,
        String companions
) {}
