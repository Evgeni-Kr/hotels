package org.example.hotels.dto;

public record HotelCreateRequestDto(
        String name,
        String description,       // optional
        String brand,
        AddressDto    address,
        ContactsDto   contacts,
        ArrivalTimeDto arrivalTime
) {}