package org.example.hotels.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Contacts {
    String phone;
    String email;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
