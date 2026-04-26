package org.example.hotels.dto;


import java.util.List;

public record HotelDetailDto(
        Long        id,
        String      name,
        String      description,
        String      brand,
        AddressDto  address,
        ContactsDto contacts,
        ArrivalTimeDto arrivalTime,
        List<String> amenities
) {}