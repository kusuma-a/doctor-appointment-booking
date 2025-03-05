package com.example.doctor_appointment_booking.repository;

import com.example.doctor_appointment_booking.entity.Appointment;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}