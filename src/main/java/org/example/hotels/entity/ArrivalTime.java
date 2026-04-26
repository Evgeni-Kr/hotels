package org.example.hotels.entity;

import jakarta.persistence.Embeddable;

import java.time.LocalTime;

@Embeddable
public class ArrivalTime {
        LocalTime checkIn;
        LocalTime checkOut;

        public ArrivalTime(LocalTime checkIn, LocalTime checkOut) {
                this.checkIn = checkIn;
                this.checkOut = checkOut;
        }

        public ArrivalTime() {
        }

        public LocalTime getCheckIn() {
                return checkIn;
        }

        public void setCheckIn(LocalTime checkIn) {
                this.checkIn = checkIn;
        }

        public LocalTime getCheckOut() {
                return checkOut;
        }

        public void setCheckOut(LocalTime checkOut) {
                this.checkOut = checkOut;
        }
}
