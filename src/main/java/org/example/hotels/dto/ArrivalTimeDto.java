package org.example.hotels.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalTime;
@Schema(description = "Время заезда и выезда")
public record ArrivalTimeDto(
        @Schema(description = "Время заезда (check-in)", example = "14:00:00")
        LocalTime checkIn,
        @Schema(description = "Время выезда (check-out)", example = "12:00:00")
        LocalTime checkOut
) {}