package org.example.hotels.service;

import org.example.hotels.dto.HotelBriefDto;
import org.example.hotels.dto.HotelDetailDto;
import org.example.hotels.entity.Address;
import org.example.hotels.entity.Hotel;
import org.example.hotels.repository.AmenityRepository;
import org.example.hotels.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.admin.SpringApplicationAdminMXBeanRegistrar;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    private HotelRepository hotelRepository;
    private AmenityRepository amenityRepository;
    private SpringApplicationAdminMXBeanRegistrar springApplicationAdminRegistrar;

    public HotelService() {

    }
    @Autowired
    public HotelService(HotelRepository hotelRepository, AmenityRepository amenityRepository, SpringApplicationAdminMXBeanRegistrar springApplicationAdminRegistrar) {
        this.hotelRepository = hotelRepository;
        this.amenityRepository = amenityRepository;
        this.springApplicationAdminRegistrar = springApplicationAdminRegistrar;
    }
    //Получает все отели из бд и передаёт DTO
    public List<HotelBriefDto> findAllHotels() {
          return   hotelRepository.findAll()
            .stream()
                    .map(this::toBriefDto)
                    .toList();
    }
    //Перевод в dto для вывода основной информации
    private HotelBriefDto toBriefDto(Hotel hotel) {
        String address = formatAddress(hotel.getAddress());
        return new HotelBriefDto(
                hotel.getId(),
                hotel.getName(),
                hotel.getDescription(),
                address,
                hotel.getContacts()!=null ? hotel.getContacts().getPhone() : ""
        );
    }
    //изменение вида адреса для краткого вывода
    private String formatAddress(Address address) {
        if(address == null) { return ""; }
        return "%d %s, %s, %s, %s".formatted(
                address.getHouseNumber(),
                address.getStreet(),
                address.getCity(),
                address.getPostalCode(),
                address.getCountry()
        );

    }
    public HotelDetailDto findHotelById(Long id) {

    }


}
