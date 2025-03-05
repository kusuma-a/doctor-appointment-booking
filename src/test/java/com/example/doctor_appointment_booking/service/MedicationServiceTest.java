package com.example.doctor_appointment_booking.service;

import com.example.doctor_appointment_booking.entity.Medication;
import com.example.doctor_appointment_booking.repository.MedicationRepository;
import com.example.doctor_appointment_booking.services.MedicationService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MedicationServiceTest {
    @Mock
    private MedicationRepository medicationRepository;

    @InjectMocks
    private MedicationService medicationService;

    @Test
    public void testAddMedication() {
        Medication medication = new Medication();
        medication.setName("Paracetamol");
        medication.setDosage("500mg");

        when(medicationRepository.save(medication)).thenReturn(medication);

        Medication savedMedication = medicationService.addMedication(medication);
        assertEquals("Paracetamol", savedMedication.getName());
    }
}