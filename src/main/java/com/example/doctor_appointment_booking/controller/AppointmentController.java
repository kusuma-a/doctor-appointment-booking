package com.example.doctor_appointment_booking.controller;

import com.example.doctor_appointment_booking.entity.Appointment;
import com.example.doctor_appointment_booking.entity.User;
import com.example.doctor_appointment_booking.repository.UserRepository;
import com.example.doctor_appointment_booking.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/book")
    public String showBookingForm(Model model) {
        List<User> doctors = userRepository.findByRole("DOCTOR");
        model.addAttribute("doctors",doctors);
        model.addAttribute("appointment", new Appointment());
        return "book-appointment";
    }

    @PostMapping("/book")
    public String bookAppointment(@ModelAttribute Appointment appointment) {
        appointmentService.bookAppointment(appointment);
        return "redirect:/appointments/success";
    }

    @GetMapping("/success")
    public String showSuccessPage() {
        return "appointment-success";
    }
}