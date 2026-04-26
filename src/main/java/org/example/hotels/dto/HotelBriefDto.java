package org.example.hotels.dto;

public record HotelBriefDto(
        Long   id,
        String name,
        String description,
        String address,
        String phone
) {}