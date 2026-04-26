package org.example.hotels.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(description = "Полная информация об отеле")
public record HotelDetailDto(

        @Schema(description = "Уникальный идентификатор", example = "1")
        Long id,

        @Schema(description = "Название отеля", example = "Radisson Blu Latvija")
        String name,

        @Schema(description = "Описание отеля", example = "5-звёздочный отель в центре Риги")
        String description,

        @Schema(description = "Бренд", example = "Radisson")
        String brand,

        @Schema(description = "Адрес отеля")
        AddressDto address,

        @Schema(description = "Контакты")
        ContactsDto contacts,

        @Schema(description = "Время заезда/выезда")
        ArrivalTimeDto arrivalTime,

        @Schema(description = "Список удобств", example = "[\"Wi-Fi\", \"Parking\", \"Spa\"]")
        List<String> amenities
) {}