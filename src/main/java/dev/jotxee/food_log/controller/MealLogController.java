package dev.jotxee.food_log.controller;

import dev.jotxee.food_log.dto.MealLogRequest;
import dev.jotxee.food_log.entity.MealLog;
import dev.jotxee.food_log.service.MealLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("api/v1/meal-logs")
public class MealLogController {
    private final MealLogService mealLogService;

    public MealLogController(MealLogService mealLogService) {
        this.mealLogService = mealLogService;
    }

    @GetMapping("/all")
    public List<MealLog> getAllMealLogs() {
        return mealLogService.getAllMeals();
    }

    @GetMapping("/{email}")
    public ResponseEntity<MealLog> getMealLogByEmail(@PathVariable String email) {
        return mealLogService.getMealByEmail(email)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<MealLogRequest>> getMealsByMonth(
            @RequestParam int year,  // Año requerido
            @RequestParam int month  // Mes requerido
    ) {
        log.info("Getting meals for year: {} and month: {}", year, month);
        return ResponseEntity.ok(mealLogService.getMealsByMonth(year, month));
    }

    @PutMapping("/{email}")
    public ResponseEntity<MealLogRequest> updateMeal(@PathVariable String email, @RequestBody MealLogRequest request) {
        return ResponseEntity.ok(mealLogService.updateMeal(email, request));
    }

    @PostMapping
    public MealLog createMealLog(@RequestBody MealLog mealLog) {
        return mealLogService.saveMeal(mealLog);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deleteMealLog(@PathVariable String email) {
        mealLogService.deleteMeal(email);
        return ResponseEntity.noContent().build();
    }
}
