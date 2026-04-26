package org.example.hotels.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Краткая информация об отеле ")
public record HotelBriefDto(
        @Schema(description = "Уникальный идентификатор", example = "1")
        Long id,
        @Schema(description = "Название отеля", example = "Radisson Blu Latvija")
        String name,
        @Schema(description = "Краткое описание", example = "5-звёздочный отель в центре Риги")
        String description,
        @Schema(description = "Адрес одной строкой", example = "55 Elizabetes, Riga, Latvia")
        String address,
        @Schema(description = "Телефон", example = "+37167000000")
        String phone
) {}