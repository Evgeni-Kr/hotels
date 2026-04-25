package org.example.hotels.service;

import org.example.hotels.dto.*;
import org.example.hotels.entity.*;
import org.springframework.stereotype.Service;

@Service
public class HotelConverterService {

    //Перевод в dto для вывода основной информации
    public HotelBriefDto toBriefDto(Hotel hotel) {
        String address = formatAddress(hotel.getAddress());
        return new HotelBriefDto(
                hotel.getId(),
                hotel.getName(),
                hotel.getDescription(),
                address,
                hotel.getContacts()!=null ? hotel.getContacts().getPhone() : ""
        );
    }

    //изменение вида адреса отеля для краткого вывода
    public String formatAddress(Address address) {
        if(address == null) { return ""; }
        return "%d %s, %s, %s, %s".formatted(
                address.getHouseNumber(),
                address.getStreet(),
                address.getCity(),
                address.getPostalCode(),
                address.getCountry()
        );

    }
    public HotelDetailDto toDetailDto(Hotel hotel) {
        AddressDto address = toAddressDto(hotel);
        ArrivalTimeDto arrivalTime = toArrivalTimeDto(hotel);
        ContactsDto contacts = toContactsDto(hotel);
        return new HotelDetailDto(
                hotel.getId(),
                hotel.getName(),
                hotel.getDescription(),
                hotel.getBrand(),
                address,
                contacts,
                arrivalTime,
                hotel.getAmenities().stream().map(Amenity::getName).sorted().toList()
        );
    }

    public ContactsDto toContactsDto(Hotel hotel) {
        Contacts contacts = hotel.getContacts();
        if(contacts == null) { return null; }
        return new ContactsDto(contacts.getPhone(), contacts.getEmail());
    }

    public ArrivalTimeDto toArrivalTimeDto(Hotel hotel) {
        ArrivalTime at = hotel.getArrivalTime();
        if(at == null) { return null; }
        return new ArrivalTimeDto(at.getCheckIn(),at.getCheckOut());
    }

    public AddressDto toAddressDto(Hotel hotel) {
        Address address = hotel.getAddress()!=null ? hotel.getAddress() : new Address();
        return new AddressDto(address.getHouseNumber(),
                address.getStreet(),
                address.getCity(),
                address.getCountry(),
                address.getPostalCode());
    }

}
