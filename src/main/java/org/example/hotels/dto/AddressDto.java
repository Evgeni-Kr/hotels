package org.example.hotels.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Адрес отеля")
public record AddressDto(
        @Schema(description = "Номер дома", example = "42")
        Integer houseNumber,
        @Schema(description = "Улица", example = "Brivibas iela")
        String  street,
        @Schema(description = "Город", example = "Riga")
        String  city,
        @Schema(description = "Страна", example = "Latvia")
        String  country,
        @Schema(description = "Почтовый индекс", example = "LV-1001")
        String  postCode
) {}