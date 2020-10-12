package com.mdfilipiaki.appointmentMedical.v1.appointment.presentation.support.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mdfilipiaki.appointmentMedical.infra.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;

@Data
@AllArgsConstructor
public class AppointmentResponse {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("medic")
    private User medic;

    @JsonProperty("customer")
    private User customer;

    @JsonProperty("dateAppointment")
    @JsonFormat(
            pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX",
            shape = JsonFormat.Shape.STRING,
            timezone = "America/Sao_Paulo"
    )
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Instant dateAppointment;

}
