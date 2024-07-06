package com.springboot.service;


import com.springboot.dto.PatientAppointmentRequest;
import com.springboot.entity.Appointment;
import com.springboot.entity.Patient;
import com.springboot.repository.AppointmentRepository;
import com.springboot.repository.PatientRepository;
import com.springboot.util.PromoCodeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PractoService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;


    @Transactional/*(rollbackFor = {IllegalAccessError.class, NullPointerException.class}
            , noRollbackFor = {ArithmeticException.class})*/
    public String bookAppointment(PatientAppointmentRequest request) {
        Patient patient = request.getPatient();
        long patientId = patientRepository.save(patient).getPatientId();

        Appointment appointment = request.getAppointment();

        if (null != appointment.getPromoCode()) {
            PromoCodeValidator.validatePromoCode(appointment.getPromoCode());
        }

        appointment.setPatientId(patientId);
        String appointmentId = appointmentRepository.save(appointment).getAppointmentId();

        return "Your Appointment Booked Successfully... Appointment Id: " + appointmentId;
    }
}
