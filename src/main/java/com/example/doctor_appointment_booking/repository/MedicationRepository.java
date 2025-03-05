package com.example.doctor_appointment_booking.repository;

import com.example.doctor_appointment_booking.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {
}