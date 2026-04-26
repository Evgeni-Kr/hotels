package org.example.hotels.service;

import org.example.hotels.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class HistogramService {

    private HotelRepository hotelRepository;

    @Autowired
    public HistogramService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }
    public Map<String,Long> createHistogram(String param) {
        return switch (param.toLowerCase()){
            case  "brand"-> hotelRepository.countHotelByBrand(param);
            case  "city"-> hotelRepository.countHotelByCity(param);
            case  "country"-> hotelRepository.countHotelByCountry(param);
            case  "amenities"-> hotelRepository.countHotelByAmenities(param);
            default ->throw  new IllegalArgumentException("Invalid param: " + param
                    +"Use brand or country or amenities or city");
        };
    }
}
