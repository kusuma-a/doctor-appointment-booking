package com.example.doctor_appointment_booking.secure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/users/register", "/login","/swagger-ui.html","/v3/api-docs/**","/swagger-resources/**","/webjars/**","/swagger-ui/**").permitAll() // Allow access to registration and login pages
                        .requestMatchers("/api/medications/**").hasAnyRole("PATIENT","DOCTOR")
                        .requestMatchers("/api/appointments/**").hasAnyRole("PATIENT","DOCTOR")
                        .requestMatchers("/patients/*").hasRole("PATIENT") // Restrict /patients/* to PATIENT role
                        .requestMatchers("/doctors/*").hasRole("DOCTOR") // Restrict /doctors/* to DOCTOR role
                        .anyRequest().authenticated() // All other requests require authentication
                )
                .formLogin(form -> form
                        .loginPage("/login") // Custom login page
                        .defaultSuccessUrl("/home") // Redirect to /home after successful login
                        .permitAll() // Allow everyone to access the login page
                )
                .logout(logout -> logout
                        .permitAll() // Allow everyone to access the logout endpoint
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Use BCrypt for password encoding
    }
}