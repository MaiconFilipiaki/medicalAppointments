package com.mdfilipiaki.appointmentMedical.v1.appointment.presentation.support.mappers;

import com.mdfilipiaki.appointmentMedical.infra.models.Appointment;
import com.mdfilipiaki.appointmentMedical.v1.appointment.presentation.support.response.AppointmentResponse;

import java.util.List;
import java.util.stream.Collectors;

public class AppointmentMapper {

    public AppointmentResponse ModelToResponse(final Appointment appointment) {
        return new AppointmentResponse(
                appointment.getId(),
                appointment.getMedic(),
                appointment.getCustomer(),
                appointment.getDateAppointment()
        );
    }

    public List<AppointmentResponse> ConvertListOfModelToResponse(final List<Appointment> appointmentList) {
        return appointmentList.stream().map(this::ModelToResponse).collect(Collectors.toList());
    }

}
