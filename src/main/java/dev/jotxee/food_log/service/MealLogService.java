package dev.jotxee.food_log.service;

import dev.jotxee.food_log.dto.MealLogRequest;
import dev.jotxee.food_log.entity.MealLog;
import dev.jotxee.food_log.mapper.MealLogMapper;
import dev.jotxee.food_log.repository.MealLogRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MealLogService {

    private final MealLogRepository mealLogRepository;

    public MealLogService(MealLogRepository mealLogRepository) {
        this.mealLogRepository = mealLogRepository;
    }

    public List<MealLog> getAllMeals() {
        return mealLogRepository.findAll();
    }

    public Optional<MealLog> getMealByEmail(String email) {
        return mealLogRepository.findById(email);
    }

    public MealLog saveMeal(MealLog mealLog) {
        return mealLogRepository.save(mealLog);
    }

    public MealLogRequest updateMeal(String email, MealLogRequest request) {
            return mealLogRepository.findById(email).map(existingMeal -> {
                updateMealFields(existingMeal, request);
                return MealLogMapper.toDTO(mealLogRepository.save(existingMeal));
            }).orElseThrow(() -> new EntityNotFoundException("MealLog not found for email: " + email));
        }

        private void updateMealFields(MealLog existingMeal, MealLogRequest request) {
            if (StringUtils.hasText(request.mealType())) existingMeal.setMealType(request.mealType());
            if (request.date() != null) existingMeal.setDate(request.date());
            if (request.time() != null) existingMeal.setTime(request.time());
            if (StringUtils.hasText(request.foodItems())) existingMeal.setFoodItems(request.foodItems());
            if (request.calories() != null) existingMeal.setCalories(request.calories());
            if (StringUtils.hasText(request.photoUrl())) existingMeal.setPhotoUrl(request.photoUrl());
            if (StringUtils.hasText(request.notes())) existingMeal.setNotes(request.notes());
            if (StringUtils.hasText(request.location())) existingMeal.setLocation(request.location());
            if (request.mood() != null && StringUtils.hasText(request.mood().name())) existingMeal.setMood(request.mood().name());
            if (StringUtils.hasText(request.dietType())) existingMeal.setDietType(request.dietType());
            if (request.diners() != null) existingMeal.setDiners(request.diners());
            if (StringUtils.hasText(request.companions())) existingMeal.setCompanions(request.companions());
        }

    public void deleteMeal(String email) {
        mealLogRepository.deleteById(email);
    }

    public List<MealLogRequest> getMealsByMonth(int year, int month) {
        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());

        return mealLogRepository.findByDateBetween(startDate, endDate)
                .stream()
                .map(MealLogMapper::toDTO)
                .toList();
    }
}
