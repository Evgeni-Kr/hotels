package org.example.hotels.repository;

import org.example.hotels.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    @Query("""
                SELECT DISTINCT h FROM Hotel h
                LEFT JOIN h.amenities a
                WHERE (:name     IS NULL OR LOWER(h.name)            LIKE LOWER(CONCAT('%', :name,    '%')))
                  AND (:brand    IS NULL OR LOWER(h.brand)           LIKE LOWER(CONCAT('%', :brand,   '%')))
                  AND (:city     IS NULL OR LOWER(h.address.city)    LIKE LOWER(CONCAT('%', :city,    '%')))
                  AND (:country  IS NULL OR LOWER(h.address.country) LIKE LOWER(CONCAT('%', :country, '%')))
                  AND (:amenityCount = 0  OR a.name IN :amenities)
            """)
    List<Hotel> findByFilters(@Param("name") String name,
                              @Param("brand") String brand,
                              @Param("city") String city,
                              @Param("country") String country,
                              @Param("amenities") List<String> amenities,
                              @Param("amenityCount") int amenityCount);


    default Map<String, Long> countHotelByBrand(String brand){
        return toMap(countByBrand(brand));
    }
    default Map<String, Long> countHotelByCity(String city){
        return toMap(countByCity(city));
    }
    default Map<String, Long> countHotelByCountry(String country){
        return toMap(countByCountry(country));
    }
    default Map<String, Long> countHotelByAmenities(String amenity){
        return toMap(countByAmenity(amenity));
    }

    private Map<String, Long> toMap(List<Object[]> list){
    return list.stream()
            .collect(Collectors.toMap(
                    r->(String) r[0],
                    r -> (Long) r[1]
            ));
    }
    @Query("SELECT h.brand, COUNT(h) FROM Hotel h GROUP BY h.brand")
    List<Object[]> countByBrand(String brand);
    @Query("SELECT h.address.city, COUNT(h) FROM Hotel h GROUP BY h.address.city")
    List<Object[]> countByCity(String city);
    @Query("SELECT h.address.country, COUNT(h) FROM Hotel h GROUP BY h.address.country")
    List<Object[]> countByCountry(String country);
    @Query("SELECT a.name, COUNT(h) FROM Hotel h JOIN h.amenities a GROUP BY a.name")
    List<Object[]> countByAmenity(String amenity);

}
