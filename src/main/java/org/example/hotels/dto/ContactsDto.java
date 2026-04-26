package org.example.hotels.dto;


import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Контактная информация отеля")
public record ContactsDto(
        @Schema(description = "Телефон", example = "+37167000000")
        String phone,
        @Schema(description = "Email", example = "info@hotel.lv")
        String email
) {}
