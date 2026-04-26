package org.example.hotels.dto;

import java.time.LocalTime;

public record ArrivalTimeDto(
        LocalTime checkIn,
        LocalTime checkOut
) {}