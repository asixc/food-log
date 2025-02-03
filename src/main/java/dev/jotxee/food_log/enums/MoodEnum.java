package dev.jotxee.food_log.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

    @Getter
    @RequiredArgsConstructor
    @Schema(description = "Available moods for meals")
    public enum MoodEnum {
        OK("Ok"),
        HAPPY("Happy"),
        NEUTRAL("Neutral"),
        SAD("Sad"),
        STRESSED("Stressed"),
        TIRED("Tired"),
        ANXIOUS("Anxious"),
        UNWELL("Unwell"),
        FRUSTRATED("Frustrated"),
        SICK("Sick");

        @JsonValue
        private final String value;

        @JsonCreator
        public static MoodEnum fromValue(String value) {
            for (MoodEnum mood : MoodEnum.values()) {
                if (mood.value.equalsIgnoreCase(value)) {
                    return mood;
                }
            }
            throw new IllegalArgumentException("Invalid mood: " + value);
        }
    }