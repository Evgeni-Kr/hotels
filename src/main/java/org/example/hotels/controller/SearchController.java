package org.example.hotels.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.hotels.dto.HotelBriefDto;
import org.example.hotels.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "search", description = "Поисковик")
@RestController
@RequestMapping("/search")
public class SearchController {

     private final HotelService hotelService;
    @Autowired
    public SearchController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @Operation(summary = "поиск",description = "Ищет отель по одному из параметров(name,brand,city,country,amenities)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Список отелей найден"),
            @ApiResponse(responseCode = "400", description = "Неверные параметры запроса"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @GetMapping
    public List<HotelBriefDto> searchHotel(@RequestParam(required = false) String name,
                                     @RequestParam(required = false) String brand,
                                     @RequestParam(required = false) String city,
                                     @RequestParam(required = false) String country,
                                     @RequestParam(required = false) List<String> amenities) {
        return hotelService.search(name,brand,city,country,amenities);
    }
}
