package org.example.hotels.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="amenity")
public class Amenity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @ManyToMany(mappedBy = "amenities")
    private Set<Hotel> hotels = new HashSet<>();

    private Amenity(AmenityBuilder builder) {
        this.name = builder.name;

    }
    public Amenity() {
    }

    public static AmenityBuilder builder(){
        return new AmenityBuilder();
    }


    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(Set<Hotel> hotels) {
        this.hotels = hotels;
    }

    public static class AmenityBuilder {
        private String name;
        private Set<Hotel> hotels = new HashSet<>();

        public AmenityBuilder name(String name) {
            this.name = name;
            return this;
        }
        public AmenityBuilder hotels(Set<Hotel> hotels) {
            this.hotels = hotels;
            return this;
        }
        public Amenity build() {
            return new Amenity(this);
        }
    }
}
