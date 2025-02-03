package dev.jotxee.food_log.mapper;

import dev.jotxee.food_log.dto.MealLogRequest;
import dev.jotxee.food_log.entity.MealLog;
import dev.jotxee.food_log.enums.MoodEnum;

public class MealLogMapper {

    public static MealLog toEntity(MealLogRequest request) {
        MealLog entity = new MealLog();
        entity.setId(request.id());
        entity.setEmail(request.email());
        entity.setMealType(request.mealType());
        entity.setDate(request.date());
        entity.setTime(request.time());
        entity.setFoodItems(request.foodItems());
        entity.setCalories(request.calories());
        entity.setPhotoUrl(request.photoUrl());
        entity.setNotes(request.notes());
        entity.setLocation(request.location());
        entity.setMood(request.mood() != null ? request.mood().getValue() : null);
        entity.setDietType(request.dietType());
        entity.setDiners(request.diners());
        entity.setCompanions(request.companions());
        return entity;
    }

    public static MealLogRequest toDTO(MealLog entity) {
        return new MealLogRequest(
                entity.getId(),
                entity.getEmail(),
                entity.getMealType(),
                entity.getDate(),
                entity.getTime(),
                entity.getFoodItems(),
                entity.getCalories(),
                entity.getPhotoUrl(),
                entity.getNotes(),
                entity.getLocation(),
                entity.getMood() != null ? MoodEnum.fromValue(entity.getMood()) : null,
                entity.getDietType(),
                entity.getDiners(),
                entity.getCompanions()
        );
    }
}

