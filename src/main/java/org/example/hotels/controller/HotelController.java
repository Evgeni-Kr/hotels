package org.example.hotels.controller;

import org.example.hotels.dto.HotelBriefDto;
import org.example.hotels.dto.HotelCreateRequestDto;
import org.example.hotels.dto.HotelDetailDto;
import org.example.hotels.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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

    @PostMapping
    public HotelBriefDto createHotel(@RequestBody HotelCreateRequestDto hotel) {
        return hotelService.create(hotel);
    }
    @PostMapping("/{id}/amenities")
    public void addAmenities(@PathVariable(name = "id") Long id, @RequestBody Set<String> amenities) {
        hotelService.addAmenities(id, amenities);
    }

}

