package com.example.doctor_appointment_booking.entity;


import jakarta.persistence.Entity;

@Entity
public class Patient extends User {
    private String contactDetails;
    private String medicalHistory;

    public Patient() {
    }


    public Patient(String email, Long id, String name, String password, String role, String contactDetails, String medicalHistory) {
        super(email, id, name, password, role);
        this.contactDetails = contactDetails;
        this.medicalHistory = medicalHistory;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }
}