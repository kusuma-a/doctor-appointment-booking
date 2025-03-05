package com.example.doctor_appointment_booking.entity;

import jakarta.persistence.Entity;

@Entity
public class Doctor extends User {
    private String specialization;

    public Doctor() {
    }

    public Doctor(String email, Long id, String name, String password, String role, String specialization) {
        super(email, id, name, password, role);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}