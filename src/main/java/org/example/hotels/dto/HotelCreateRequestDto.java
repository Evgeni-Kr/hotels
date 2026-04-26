package org.example.hotels.dto;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Запрос на создание нового отеля")
public record HotelCreateRequestDto(
        @Schema(description = "Название отеля", example = "Radisson Blu Latvija", requiredMode = Schema.RequiredMode.REQUIRED)
        String name,

        @Schema(description = "Описание отеля (необязательно)", example = "Современный отель в центре города")
        String description,

        @Schema(description = "Бренд отеля", example = "Radisson", requiredMode = Schema.RequiredMode.REQUIRED)
        String brand,

        @Schema(description = "Адрес отеля", requiredMode = Schema.RequiredMode.REQUIRED)
        AddressDto address,

        @Schema(description = "Контакты отеля", requiredMode = Schema.RequiredMode.REQUIRED)
        ContactsDto contacts,

        @Schema(description = "Время заезда/выезда", requiredMode = Schema.RequiredMode.REQUIRED)
        ArrivalTimeDto arrivalTime
) {}