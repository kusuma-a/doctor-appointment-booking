package com.example.doctor_appointment_booking.controller;

import com.example.doctor_appointment_booking.entity.Doctor;
import com.example.doctor_appointment_booking.entity.Patient;
import com.example.doctor_appointment_booking.entity.User;
import com.example.doctor_appointment_booking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("patient",  new Patient());
        model.addAttribute("doctor", new Doctor());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String role,
                               @RequestParam String name,
                               @RequestParam String email,
                               @RequestParam String password) {
        if (role.equals("PATIENT")) {
            // Create a Patient object
            Patient patient = new Patient();
            patient.setName(name);
            patient.setEmail(email);
            patient.setPassword(password);
            patient.setRole(role);
            userService.registerUser(patient); // Save the patient
        } else if (role.equals("DOCTOR")) {
            // Create a Doctor object
            Doctor doctor = new Doctor();
            doctor.setName(name);
            doctor.setEmail(email);
            doctor.setPassword(password);
            doctor.setRole(role);
            userService.registerUser(doctor); // Save the doctor
        }
        return "redirect:/login"; // Redirect to login page
    }
}