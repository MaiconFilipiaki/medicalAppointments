package com.mdfilipiaki.appointmentMedical.v1.appointment.presentation;

import com.mdfilipiaki.appointmentMedical.v1.appointment.infra.AppointmentService;
import com.mdfilipiaki.appointmentMedical.v1.appointment.presentation.support.mappers.AppointmentMapper;
import com.mdfilipiaki.appointmentMedical.v1.appointment.presentation.support.request.CreateAppointmentRequest;
import com.mdfilipiaki.appointmentMedical.v1.appointment.presentation.support.response.AppointmentResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/appointment")
@AllArgsConstructor
public class AppointmentResource {

    final private AppointmentService appointmentService;

    @GetMapping
    ResponseEntity<List<AppointmentResponse>> listAll() {
        return ResponseEntity.ok().body(
                new AppointmentMapper().ConvertListOfModelToResponse(appointmentService.getAllAppointment())
        );
    }

    @PostMapping
    ResponseEntity<AppointmentResponse> create(@Valid @RequestBody final CreateAppointmentRequest createAppointmentRequest) {
        return ResponseEntity.ok().body(
                new AppointmentMapper().ModelToResponse(appointmentService.createAppointment(createAppointmentRequest))
        );
    }

}
