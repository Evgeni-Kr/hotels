package org.example.hotels.controller;

import org.example.hotels.dto.HotelBriefDto;
import org.example.hotels.dto.HotelDetailDto;
import org.example.hotels.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private final  HotelService hotelService;
    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }
    @GetMapping
    public List<HotelBriefDto> getHotels() {
        return hotelService.findAllHotels();
    }
    @GetMapping("/{id}")
    public HotelDetailDto getHotel(@PathVariable(name = "id") Long id) {

        return hotelService.findHotelById(id);
    }
}

