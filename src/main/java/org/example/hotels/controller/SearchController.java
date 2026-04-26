package org.example.hotels.controller;

import org.example.hotels.dto.HotelBriefDto;
import org.example.hotels.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

     private HotelService hotelService;
    @Autowired
    public SearchController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public List<HotelBriefDto> searchHotel(@RequestParam(required = false) String name,
                                     @RequestParam(required = false) String brand,
                                     @RequestParam(required = false) String city,
                                     @RequestParam(required = false) String country,
                                     @RequestParam(required = false) List<String> amenities) {
        return hotelService.search(name,brand,city,country,amenities);
    }
}
