package org.example.hotels.service;

import org.example.hotels.dto.HotelBriefDto;
import org.example.hotels.dto.HotelCreateRequestDto;
import org.example.hotels.dto.HotelDetailDto;
import org.example.hotels.entity.*;
import org.example.hotels.exception.NotFoundException;
import org.example.hotels.repository.AmenityRepository;
import org.example.hotels.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;
    private final AmenityRepository amenityRepository;
    private final HotelConverterService hotelConverterService;

    @Autowired
    public HotelService(HotelRepository hotelRepository,
                        AmenityRepository amenityRepository,
                        HotelConverterService hotelConverterService) {
        this.hotelRepository = hotelRepository;
        this.amenityRepository = amenityRepository;
        this.hotelConverterService = hotelConverterService;
    }

    @Transactional(readOnly = true)
    public List<HotelBriefDto> findAllHotels() {
        return hotelRepository.findAll()
                .stream()
                .map(hotelConverterService::toBriefDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public HotelDetailDto findHotelById(Long id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(
                () -> new NotFoundException("hotel not found id:" + id));
        return hotelConverterService.toDetailDto(hotel);
    }

    @Transactional
    public HotelBriefDto create(HotelCreateRequestDto req) {
        Hotel hotel = Hotel.builder()
                .name(req.name())
                .description(req.description())
                .brand(req.brand())
                .address(new Address(
                        req.address().houseNumber(),
                        req.address().street(),
                        req.address().city(),
                        req.address().country(),
                        req.address().postCode()))
                .contacts(new Contacts(
                        req.contacts().phone(),
                        req.contacts().email()))
                .arrivalTime(new ArrivalTime(
                        req.arrivalTime().checkIn(),
                         req.arrivalTime().checkOut()))
                .build();
        return hotelConverterService.toBriefDto(hotelRepository.save(hotel));
    }

    @Transactional
    public void addAmenities(Long hotelId, Set<String> amenities) {
        Hotel hotel= hotelRepository.findById(hotelId).orElseThrow(()->new NotFoundException("hotel not found id:" + hotelId));
        Set<Amenity> amenitiesSet = amenities.stream()
                .map(name -> amenityRepository.findAmenityByName(name)
                        .orElseGet(() -> amenityRepository.save(
                                Amenity.builder().name(name).build())))
                .collect(Collectors.toSet());
        hotel.addAllAmenities(amenitiesSet);
        hotelRepository.save(hotel);
    }
}
