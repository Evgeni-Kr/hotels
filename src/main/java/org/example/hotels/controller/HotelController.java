package org.example.hotels.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.hotels.dto.HotelBriefDto;
import org.example.hotels.dto.HotelCreateRequestDto;
import org.example.hotels.dto.HotelDetailDto;
import org.example.hotels.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Tag(name = "Hotels", description = "Управление отелями")
@RestController
@RequestMapping("/hotels")
public class HotelController {

    private final  HotelService hotelService;
    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @Operation(summary = "Получения всех отелей", description = "Позволяет получить краткую информацию о всех отелях")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Hotels found"),
            @ApiResponse(responseCode = "404", description = "Hotels not found")
    })
    @GetMapping
    public List<HotelBriefDto> getHotels() {
        return hotelService.findAllHotels();
    }

    @Operation(summary = "Получения отеля по id",description = "Позволяет получить отель по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Hotels found"),
            @ApiResponse(responseCode = "404", description = "Hotels not found")
    })
    @GetMapping("/{id}")
    public HotelDetailDto getHotel(@PathVariable(name = "id") Long id) {

        return hotelService.findHotelById(id);
    }

    @Operation(summary = "создание отеля", description = "создание отеля")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Отель успешно создан"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @PostMapping
    public HotelBriefDto createHotel(@RequestBody HotelCreateRequestDto hotel) {
        return hotelService.create(hotel);
    }


    @Operation(summary = "добавление удобств", description = "добавляет удобства для отеля Id которого был передан")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Удобства добавлены"),
            @ApiResponse(responseCode = "404", description = "Отель не найден"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные")
    })
    @PostMapping("/{id}/amenities")
    public void addAmenities(@PathVariable(name = "id") Long id, @RequestBody Set<String> amenities) {
        hotelService.addAmenities(id, amenities);
    }

}

