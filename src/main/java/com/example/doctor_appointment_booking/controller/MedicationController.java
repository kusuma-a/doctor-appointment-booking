package com.example.doctor_appointment_booking.controller;

import com.example.doctor_appointment_booking.entity.Medication;
import com.example.doctor_appointment_booking.services.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/medications")
public class MedicationController {
    @Autowired
    private MedicationService medicationService;

    @GetMapping("/add")
    public String showAddMedicationForm(Model model) {
        model.addAttribute("medication", new Medication());
        return "add-medication";
    }

    @PostMapping("/add")
    public String addMedication(@ModelAttribute Medication medication) {
        medicationService.addMedication(medication);
        return "redirect:/medications/list";
    }

    @GetMapping("/list")
    public String listMedications(Model model) {
        model.addAttribute("medications", medicationService.getAllMedications());
        return "medication-list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("medication", medicationService.getMedicationById(id));
        return "edit-medication";
    }

    @PostMapping("/edit/{id}")
    public String updateMedication(@PathVariable Long id, @ModelAttribute Medication medication) {
        medicationService.updateMedication(id, medication);
        return "redirect:/medications/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteMedication(@PathVariable Long id) {
        medicationService.deleteMedication(id);
        return "redirect:/medications/list";
    }
}