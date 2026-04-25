package org.example.hotels.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Embedded
    private Address address;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(nullable = false)
    private String brand;
    @Embedded
    private Contacts contacts;
    @Embedded
    private ArrivalTime arrivalTime;
    @ManyToMany()
    @JoinTable(
            name = "hotel-amenities",
            joinColumns = @JoinColumn(name = "hotel_id"),
            inverseJoinColumns = @JoinColumn(name = "amenity_id")
    )
    private Set<Amenity> amenities = new HashSet<>();

    public Hotel() {

    }

    private Hotel(HotelBuilder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.brand = builder.brand;
        this.contacts = builder.contacts;
        this.arrivalTime = builder.arrivalTime;
        this.address = builder.address;
        this.amenities = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public ArrivalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(ArrivalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Set<Amenity> getAmenities() {
        return amenities;
    }

    public void addAmenity(Amenity amenities) {
        this.amenities.add(amenities);
    }

    public void addAllAmenities(Set<Amenity> amenities) {
        this.amenities.addAll(amenities);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static HotelBuilder builder() {
        return new HotelBuilder();
    }

    public static class HotelBuilder {
        private String name;
        private String description;
        private String brand;
        private Contacts contacts;
        private ArrivalTime arrivalTime;
        private Address address;


        public HotelBuilder name(String name) {
            this.name = name;
            return this;
        }

        public HotelBuilder description(String description) {
            this.description = description;
            return this;
        }

        public HotelBuilder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public HotelBuilder contacts(Contacts contacts) {
            this.contacts = contacts;
            return this;
        }

        public HotelBuilder arrivalTime(ArrivalTime arrivalTime) {
            this.arrivalTime = arrivalTime;
            return this;
        }

        public HotelBuilder address(Address address) {
            this.address = address;
            return this;
        }

        public Hotel build() {
            return new Hotel(this);
        }
    }
}

