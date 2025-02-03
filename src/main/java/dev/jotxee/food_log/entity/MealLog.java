package dev.jotxee.food_log.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

@Entity
@Table(name = "meal_log")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MealLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email; // Correo electrónico del usuario que registró la comida

    @Column(name = "meal_type", nullable = false)
    private String mealType; // Tipo de comida (desayuno, almuerzo, merienda, cena)

    @Column(name = "date", nullable = false)
    private LocalDate date; // Fecha en que se consumió la comida

    @Column(name = "time", nullable = false)
    private LocalTime time; // Hora exacta de la comida

    @Column(name = "food_items", nullable = false, columnDefinition = "TEXT")
    private String foodItems; // Lista de alimentos consumidos

    @Column(name = "calories")
    private Double calories; // Estimación de calorías consumidas

    @Column(name = "photo_url")
    private String photoUrl; // URL de la foto de la comida

    @Column(name = "notes")
    private String notes; // Notas adicionales sobre la comida

    @Column(name = "location")
    private String location; // Ubicación donde se consumió la comida

    @Column(name = "mood")
    private String mood; // Estado de ánimo al comer

    @Column(name = "diet_type")
    private String dietType; // Tipo de dieta

    @Column(name = "diners", nullable = false)
    private Integer diners; // Número de comensales en la comida

    @Column(name = "companions", columnDefinition = "TEXT")
    private String companions; // Nombres de las personas con quienes se compartió la comida

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now(); // Fecha y hora de creación del registro
}
