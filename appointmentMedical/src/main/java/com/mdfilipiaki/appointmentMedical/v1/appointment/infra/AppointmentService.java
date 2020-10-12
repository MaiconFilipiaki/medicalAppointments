package com.mdfilipiaki.appointmentMedical.v1.appointment.infra;

import com.mdfilipiaki.appointmentMedical.infra.enumeration.UserType;
import com.mdfilipiaki.appointmentMedical.infra.exceptions.DataIntegrityException;
import com.mdfilipiaki.appointmentMedical.infra.models.Appointment;
import com.mdfilipiaki.appointmentMedical.infra.models.User;
import com.mdfilipiaki.appointmentMedical.infra.repository.AppointmentRepository;
import com.mdfilipiaki.appointmentMedical.infra.repository.UserRepository;
import com.mdfilipiaki.appointmentMedical.v1.appointment.presentation.support.request.CreateAppointmentRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AppointmentService {

    final private AppointmentRepository appointmentRepository;

    final private UserRepository userRepository;

    public Appointment createAppointment(final CreateAppointmentRequest createAppointmentRequest) {
        final User medic = userRepository.findById(createAppointmentRequest.getIdMedic()).orElseThrow(() -> {
            throw new DataIntegrityException("id of medic informed not found");
        });
        final User customer = userRepository.findById(createAppointmentRequest.getIdCustomer()).orElseThrow(() -> {
            throw new DataIntegrityException("id of customer informed not found");
        });
        if (!medic.getType().getValue().equals(UserType.MEDIC.getValue())
                || !customer.getType().getValue().equals(UserType.CUSTOMER.getValue())) {
            throw new DataIntegrityException("To create an appointment you must inform a medic and customer valid");
        }

        return appointmentRepository.save(
                new Appointment(medic, customer, createAppointmentRequest.getDateAppointment())
        );
    }

    public List<Appointment> getAllAppointment() {
        return appointmentRepository.findAll();
    }

}
