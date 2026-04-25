package org.example.hotels.entity;

import jakarta.persistence.Embeddable;

import java.time.LocalTime;

@Embeddable
public class ArrivalTime {
        LocalTime checkIn;
        LocalTime checkOut;
}
