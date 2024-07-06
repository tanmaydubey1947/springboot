package com.springboot.dto;

import com.springboot.entity.Appointment;
import com.springboot.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientAppointmentRequest {

    private Patient patient;
    private Appointment appointment;
}
